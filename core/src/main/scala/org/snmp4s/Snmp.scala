/*
 * Copyright 2013 org.snmp4s
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance 
 * with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is 
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License.
 */

package org.snmp4s

import org.snmp4j.{CommunityTarget, PDU, ScopedPDU, Target, UserTarget, Snmp => Snmp4j}
import org.snmp4j.smi.{GenericAddress, Integer32, OID, OctetString, Variable, VariableBinding}
import org.snmp4j.transport.DefaultUdpTransportMapping
import org.snmp4j.util.TreeUtils
import org.snmp4j.util.DefaultPDUFactory

import scala.collection.JavaConversions._
import Mib._
import org.snmp4j.mp.MPv3
import org.snmp4j.security.{SecurityLevel, SecurityModels, SecurityProtocols, USM, UsmUser}
import org.snmp4s.SnmpParams.{Op, Read, Write}

sealed trait SnmpError

case object AuthorizationError extends SnmpError

case object BadValue extends SnmpError

case object CommitFailed extends SnmpError

case object GeneralError extends SnmpError

case object InconsistentName extends SnmpError

case object InconsistentValue extends SnmpError

case object NoAccessError extends SnmpError

case object NoCreation extends SnmpError

case object NoSuchName extends SnmpError

case object NotWritable extends SnmpError

case object ReadOnlyError extends SnmpError

case object ResourceUnavailable extends SnmpError

case object TooBig extends SnmpError

case object UndoFailed extends SnmpError

case object WrongEncoding extends SnmpError

case object WrongLength extends SnmpError

case object WrongType extends SnmpError

case object WrongValue extends SnmpError

case object UnsupportedSyntax extends SnmpError

case object AgentUnreachable extends SnmpError

case object AgentUnknown extends SnmpError

case class ExceptionThrown(e: Exception) extends SnmpError

case class UndefinedError(i: Int) extends SnmpError

private object ErrorMap extends (Int => SnmpError) {

  import org.snmp4j.mp.SnmpConstants._

  private val m = Map(
    SNMP_ERROR_AUTHORIZATION_ERROR -> AuthorizationError,
    SNMP_ERROR_BAD_VALUE -> BadValue,
    SNMP_ERROR_COMMIT_FAILED -> CommitFailed,
    SNMP_ERROR_GENERAL_ERROR -> GeneralError,
    SNMP_ERROR_INCONSISTENT_NAME -> InconsistentName,
    SNMP_ERROR_INCONSISTENT_VALUE -> InconsistentValue,
    SNMP_ERROR_NO_ACCESS -> NoAccessError,
    SNMP_ERROR_NO_CREATION -> NoCreation,
    SNMP_ERROR_NO_SUCH_NAME -> NoSuchName,
    SNMP_ERROR_NOT_WRITEABLE -> NotWritable,
    SNMP_ERROR_READ_ONLY -> ReadOnlyError,
    SNMP_ERROR_RESOURCE_UNAVAILABLE -> ResourceUnavailable,
    SNMP_ERROR_TOO_BIG -> TooBig,
    SNMP_ERROR_UNDO_FAILED -> UndoFailed,
    SNMP_ERROR_WRONG_ENCODING -> WrongEncoding,
    SNMP_ERROR_WRONG_LENGTH -> WrongLength,
    SNMP_ERROR_WRONG_TYPE -> WrongType,
    SNMP_ERROR_WRONG_VALUE -> WrongValue
  )

  def apply(i: Int) = m.get(i) match {
    case Some(e) => e
    case _ => UndefinedError(i)
  }
}

case class SnmpParams(
                       ip: String = "127.0.0.1",
                       port: Int = 161,
                       read: String = "public",
                       write: String = "private",
                       version: Version = Version1,
                       retries: Int = 2,
                       timeout: Long = 1500,
                       authProtocol: Option[OID] = None,
                       privProtocol: Option[OID] = None,
                       authPass: Option[String] = None,
                       privPass: Option[String] = None,
                       username: Option[String] = None) {

  private val addr = GenericAddress.parse(s"udp:$ip/$port")

  def target(op: Op): Target = {
    val target = version match {
      case Version1 | Version2c =>
        val t = new CommunityTarget
        t.setCommunity(new OctetString(op match {
          case SnmpParams.Read => read
          case SnmpParams.Write => write
        }))
        t
      case Version3 =>
        val t = new UserTarget()
        authPass match {
          case Some(_) => privPass match {
            case Some(_) => t.setSecurityLevel(SecurityLevel.AUTH_PRIV)
            case None => t.setSecurityLevel(SecurityLevel.AUTH_NOPRIV)
          }
          case None => t.setSecurityLevel(SecurityLevel.NOAUTH_NOPRIV)
        }
        username.foreach(v => t.setSecurityName(new OctetString(v)))
        t
    }
    target.setAddress(addr)
    target.setRetries(retries)
    target.setTimeout(timeout)
    target.setVersion(version.enum)
    target
  }

  lazy val localEngineID = new OctetString(MPv3.createLocalEngineID());
}

object SnmpParams {
  sealed trait Op
  case object Read extends Op
  case object Write extends Op
}

/**
  * Performs the SNMP work synchronously
  */
class SnmpSync(params: SnmpParams) {

  import params.target
  private val map = new DefaultUdpTransportMapping
  private val snmp = new Snmp4j(map)
  params.version match {
    case Version3 =>
      val usm = new USM(SecurityProtocols.getInstance(),
        params.localEngineID, 0)
      SecurityModels.getInstance().addSecurityModel(usm)
      params.username.map(s2os).foreach { u =>
        snmp.getUSM.addUser(u, new UsmUser(u,
          params.authProtocol.orNull, params.authPass.map(s2os).orNull,
          params.privProtocol.orNull, params.privPass.map(s2os).orNull));
      }
    case _ => // noop
  }
  map.listen()

  protected implicit def Oid2Snmp4j(o: Oid): OID = new OID(o.toArray)

  protected implicit def Snmp4j2Oid(o: OID): Oid = o.getValue()

  protected def s2os(s: String): OctetString = new OctetString(s)

  protected def createPdu: PDU = params.version match {
    case Version3 => new ScopedPDU
    case _ => new PDU
  }

  def get[T](req: GetRequest[T]) = {
    def pack[U](req: GetRequest[U]): (PDU => PDU) =
      req match {
        case SingleGetRequest(obj) => { pdu: PDU =>
          pdu.add(new VariableBinding(obj.oid))
          pdu
        }
        case CompoundGetRequest(obj, next) => { pdu: PDU =>
          pdu.add(new VariableBinding(obj.oid))
          pack(next)(pdu)
        }
      }

    def unpack[U](req: GetRequest[U]):
    (Seq[Either[SnmpError, Variable]] => GetResponse[U]) = {
      req match {
        case SingleGetRequest(obj) => { res =>
          SingleGetResponse(res.head match {
            case Left(e) => Left(e)
            case Right(v) => cast(obj, v)
          })
        }
        case CompoundGetRequest(obj, next) => { res =>
          (res.head match {
            case Left(e) => Left(e)
            case Right(v) => cast(obj, v)
          }) &: unpack(next).apply(res.tail)
        }
      }
    }

    doGet(pack(req), unpack(req))
  }

  protected def doGet[R](pack: (PDU => PDU), unpack: (Seq[Either[SnmpError, Variable]]) => R): Either[SnmpError, R] = {
    try {
      val pdu = createPdu
      pdu.setType(PDU.GET)
      pack(pdu)

      val event = snmp.get(pdu, target(Read))
      val res = Option(event.getResponse)

      res match {
        case Some(res) => {
          val vars = res.getVariableBindings().map(vb => vb getVariable)
          val err = if (res.getErrorStatus > 0)
            Some((ErrorMap(res.getErrorStatus)), res.getErrorIndex())
          else
            None

          val combined = Stream.from(1).zip(vars) map { case (index, v) =>
            err match {
              case Some((e, i)) => if (index == i) Left(e) else Right(v)
              case _ => Right(v)
            }
          }
          Right(unpack(combined))
        }
        case None => {
          Left(AgentUnreachable)
        }
      }
    } catch {
      case e: NullPointerException => Left(AgentUnknown)
    }
  }

  /**
    * Perform an SNMP set 
    */
  def set[T](req: SetRequest[T]): Option[SnmpError] = {
    def pack[U](req: SetRequest[U]): (PDU => PDU) =
      req match {
        case SingleSetRequest(vb) => { pdu: PDU =>
          pdu.add(new VariableBinding(vb.obj.oid, toVariable(vb.obj, vb.v)))
          pdu
        }
        case CompoundSetRequest(vb, next) => { pdu: PDU =>
          pdu.add(new VariableBinding(vb.obj.oid, toVariable(vb.obj, vb.v)))
          pack(next)(pdu)
        }
      }

    doSet(pack(req))
  }

  protected def doSet(pack: (PDU => PDU)): Option[SnmpError] = {
    try {
      val pdu = createPdu
      pdu.setType(PDU.SET)
      pack(pdu)

      val event = snmp.set(pdu, target(Write))
      val res = Option(event.getResponse)

      res match {
        case Some(res) => if (res.getErrorStatus > 0) {
          val i = res.getErrorIndex()
          val vb = res.get(i - 1)
          val v = vb.getVariable
          Some(ErrorMap(res.getErrorStatus))
        } else None
        case None => Some(AgentUnreachable)
      }
    } catch {
      case e: NullPointerException => Some(AgentUnknown)
    }
  }

  /**
    * Perform an SNMP walk against a readable OID
    */
  def walk[A <: Readable, T](obj: AccessibleObject[A, T], ver: Version = Version1): Either[SnmpError, Seq[VarBind[A, T]]] = {
    try {
      val events = (new TreeUtils(snmp, new DefaultPDUFactory(PDU.GETNEXT))).walk(target(Read), Array(obj.oid))

      if (events.find(e => e.getVariableBindings() == null).isDefined) {
        Left(AgentUnreachable)
      } else {
        val vbs: Seq[VarBind[A, T]] = for {
          event <- events
          vb <- event.getVariableBindings()
        } yield {
          val o: Oid = vb.getOid()
          val v = vb.getVariable

          // Fix this patch right.get:
          VarBind(obj(o drop obj.oid.length), cast(obj, v).right.get)
        }

        Right(vbs)
      }
    } catch {
      // This is a little sketchy.  I know for sure that a NullPointerException is thrown 
      // by snmp4j when the agent DNS name is unresolved.  However, there could be other 
      // conditions that cause a NullPointerException.
      case n: NullPointerException => Left(AgentUnknown)
    }
  }

  protected def toVariable[A <: Writable, T](obj: MibObject[A], v: T): Variable = {
    if (obj.enum.isDefined) new Integer32(fromEnum(v))
    else if (OctetStringSyntax == obj.syntax) new OctetString(v.asInstanceOf[String])
    else if (IntegerSyntax == obj.syntax) new Integer32(v.asInstanceOf[Int])
    else new org.snmp4j.smi.Null
  }

  private def fromEnum[T](v: T): Int = {
    val c = v.getClass()
    val m = c.getDeclaredMethod("id")
    val r = m.invoke(v)
    r.asInstanceOf[Int]
  }

  protected def cast[A <: Readable, T](obj: MibObject[A], v: Variable): Either[SnmpError, T] = {
    try {
      val r = if (obj.enum isDefined)
        Right(obj.enum.get(v.toInt))
      else if (OctetStringSyntax == obj.syntax)
        Right(v.toString())
      else if (IntegerSyntax == obj.syntax)
        Right(v.toInt())
      else
        Left(WrongValue)

      r match {
        case Left(e) => Left(e)
        case Right(v) => Right(v.asInstanceOf[T])
      }
    } catch {
      // This wrong value case happens when there are more than one errored variables in a get response.
      case e: Exception => Left(WrongValue)
    }
  }
}

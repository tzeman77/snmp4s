package org.snmp4s
package IfMib

case object IfNumber extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,1), "ifNumber", IntegerSyntax) with Scalar[ReadOnly, Int]
case object IfTableLastChange extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,5), "ifTableLastChange", IntegerSyntax) with Scalar[ReadOnly, Int]
case object IfIndex extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,1), "ifIndex", IntegerSyntax)
case object IfDescr extends AccessibleObject[ReadOnly, String](Seq(1,3,6,1,2,1,2,2,1,2), "ifDescr", OctetStringSyntax)
object IfType_enum extends EnumInteger {
  type IfType = Value
  val Other = Value(1, "other")
  val Regular1822 = Value(2, "regular1822")
  val Hdh1822 = Value(3, "hdh1822")
  val DdnX25 = Value(4, "ddnX25")
  val Rfc877x25 = Value(5, "rfc877x25")
  val EthernetCsmacd = Value(6, "ethernetCsmacd")
  val Iso88023Csmacd = Value(7, "iso88023Csmacd")
  val Iso88024TokenBus = Value(8, "iso88024TokenBus")
  val Iso88025TokenRing = Value(9, "iso88025TokenRing")
  val Iso88026Man = Value(10, "iso88026Man")
  val StarLan = Value(11, "starLan")
  val Proteon10Mbit = Value(12, "proteon10Mbit")
  val Proteon80Mbit = Value(13, "proteon80Mbit")
  val Hyperchannel = Value(14, "hyperchannel")
  val Fddi = Value(15, "fddi")
  val Lapb = Value(16, "lapb")
  val Sdlc = Value(17, "sdlc")
  val Ds1 = Value(18, "ds1")
  val E1 = Value(19, "e1")
  val BasicISDN = Value(20, "basicISDN")
  val PrimaryISDN = Value(21, "primaryISDN")
  val PropPointToPointSerial = Value(22, "propPointToPointSerial")
  val Ppp = Value(23, "ppp")
  val SoftwareLoopback = Value(24, "softwareLoopback")
  val Eon = Value(25, "eon")
  val Ethernet3Mbit = Value(26, "ethernet3Mbit")
  val Nsip = Value(27, "nsip")
  val Slip = Value(28, "slip")
  val Ultra = Value(29, "ultra")
  val Ds3 = Value(30, "ds3")
  val Sip = Value(31, "sip")
  val FrameRelay = Value(32, "frameRelay")
  val Rs232 = Value(33, "rs232")
  val Para = Value(34, "para")
  val Arcnet = Value(35, "arcnet")
  val ArcnetPlus = Value(36, "arcnetPlus")
  val Atm = Value(37, "atm")
  val Miox25 = Value(38, "miox25")
  val Sonet = Value(39, "sonet")
  val X25ple = Value(40, "x25ple")
  val Iso88022llc = Value(41, "iso88022llc")
  val LocalTalk = Value(42, "localTalk")
  val SmdsDxi = Value(43, "smdsDxi")
  val FrameRelayService = Value(44, "frameRelayService")
  val V35 = Value(45, "v35")
  val Hssi = Value(46, "hssi")
  val Hippi = Value(47, "hippi")
  val Modem = Value(48, "modem")
  val Aal5 = Value(49, "aal5")
  val SonetPath = Value(50, "sonetPath")
  val SonetVT = Value(51, "sonetVT")
  val SmdsIcip = Value(52, "smdsIcip")
  val PropVirtual = Value(53, "propVirtual")
  val PropMultiplexor = Value(54, "propMultiplexor")
  val Ieee80212 = Value(55, "ieee80212")
  val FibreChannel = Value(56, "fibreChannel")
  val HippiInterface = Value(57, "hippiInterface")
  val FrameRelayInterconnect = Value(58, "frameRelayInterconnect")
  val Aflane8023 = Value(59, "aflane8023")
  val Aflane8025 = Value(60, "aflane8025")
  val CctEmul = Value(61, "cctEmul")
  val FastEther = Value(62, "fastEther")
  val Isdn = Value(63, "isdn")
  val V11 = Value(64, "v11")
  val V36 = Value(65, "v36")
  val G703at64k = Value(66, "g703at64k")
  val G703at2mb = Value(67, "g703at2mb")
  val Qllc = Value(68, "qllc")
  val FastEtherFX = Value(69, "fastEtherFX")
  val Channel = Value(70, "channel")
  val Ieee80211 = Value(71, "ieee80211")
  val Ibm370parChan = Value(72, "ibm370parChan")
  val Escon = Value(73, "escon")
  val Dlsw = Value(74, "dlsw")
  val Isdns = Value(75, "isdns")
  val Isdnu = Value(76, "isdnu")
  val Lapd = Value(77, "lapd")
  val IpSwitch = Value(78, "ipSwitch")
  val Rsrb = Value(79, "rsrb")
  val AtmLogical = Value(80, "atmLogical")
  val Ds0 = Value(81, "ds0")
  val Ds0Bundle = Value(82, "ds0Bundle")
  val Bsc = Value(83, "bsc")
  val Async = Value(84, "async")
  val Cnr = Value(85, "cnr")
  val Iso88025Dtr = Value(86, "iso88025Dtr")
  val Eplrs = Value(87, "eplrs")
  val Arap = Value(88, "arap")
  val PropCnls = Value(89, "propCnls")
  val HostPad = Value(90, "hostPad")
  val TermPad = Value(91, "termPad")
  val FrameRelayMPI = Value(92, "frameRelayMPI")
  val X213 = Value(93, "x213")
  val Adsl = Value(94, "adsl")
  val Radsl = Value(95, "radsl")
  val Sdsl = Value(96, "sdsl")
  val Vdsl = Value(97, "vdsl")
  val Iso88025CRFPInt = Value(98, "iso88025CRFPInt")
  val Myrinet = Value(99, "myrinet")
  val VoiceEM = Value(100, "voiceEM")
  val VoiceFXO = Value(101, "voiceFXO")
  val VoiceFXS = Value(102, "voiceFXS")
  val VoiceEncap = Value(103, "voiceEncap")
  val VoiceOverIp = Value(104, "voiceOverIp")
  val AtmDxi = Value(105, "atmDxi")
  val AtmFuni = Value(106, "atmFuni")
  val AtmIma = Value(107, "atmIma")
  val PppMultilinkBundle = Value(108, "pppMultilinkBundle")
  val IpOverCdlc = Value(109, "ipOverCdlc")
  val IpOverClaw = Value(110, "ipOverClaw")
  val StackToStack = Value(111, "stackToStack")
  val VirtualIpAddress = Value(112, "virtualIpAddress")
  val Mpc = Value(113, "mpc")
  val IpOverAtm = Value(114, "ipOverAtm")
  val Iso88025Fiber = Value(115, "iso88025Fiber")
  val Tdlc = Value(116, "tdlc")
  val GigabitEthernet = Value(117, "gigabitEthernet")
  val Hdlc = Value(118, "hdlc")
  val Lapf = Value(119, "lapf")
  val V37 = Value(120, "v37")
  val X25mlp = Value(121, "x25mlp")
  val X25huntGroup = Value(122, "x25huntGroup")
  val TrasnpHdlc = Value(123, "trasnpHdlc")
  val Interleave = Value(124, "interleave")
  val Fast = Value(125, "fast")
  val Ip = Value(126, "ip")
  val DocsCableMaclayer = Value(127, "docsCableMaclayer")
  val DocsCableDownstream = Value(128, "docsCableDownstream")
  val DocsCableUpstream = Value(129, "docsCableUpstream")
  val A12MppSwitch = Value(130, "a12MppSwitch")
  val Tunnel = Value(131, "tunnel")
  val Coffee = Value(132, "coffee")
  val Ces = Value(133, "ces")
  val AtmSubInterface = Value(134, "atmSubInterface")
  val L2vlan = Value(135, "l2vlan")
  val L3ipvlan = Value(136, "l3ipvlan")
  val L3ipxvlan = Value(137, "l3ipxvlan")
  val DigitalPowerline = Value(138, "digitalPowerline")
  val MediaMailOverIp = Value(139, "mediaMailOverIp")
  val Dtm = Value(140, "dtm")
  val Dcn = Value(141, "dcn")
  val IpForward = Value(142, "ipForward")
  val Msdsl = Value(143, "msdsl")
  val Ieee1394 = Value(144, "ieee1394")
  val IfGsn = Value(145, "if-gsn")
  val DvbRccMacLayer = Value(146, "dvbRccMacLayer")
  val DvbRccDownstream = Value(147, "dvbRccDownstream")
  val DvbRccUpstream = Value(148, "dvbRccUpstream")
  val AtmVirtual = Value(149, "atmVirtual")
  val MplsTunnel = Value(150, "mplsTunnel")
  val Srp = Value(151, "srp")
  val VoiceOverAtm = Value(152, "voiceOverAtm")
  val VoiceOverFrameRelay = Value(153, "voiceOverFrameRelay")
  val Idsl = Value(154, "idsl")
  val CompositeLink = Value(155, "compositeLink")
  val Ss7SigLink = Value(156, "ss7SigLink")
  val PropWirelessP2P = Value(157, "propWirelessP2P")
  val FrForward = Value(158, "frForward")
  val Rfc1483 = Value(159, "rfc1483")
  val Usb = Value(160, "usb")
  val Ieee8023adLag = Value(161, "ieee8023adLag")
  val Bgppolicyaccounting = Value(162, "bgppolicyaccounting")
  val Frf16MfrBundle = Value(163, "frf16MfrBundle")
  val H323Gatekeeper = Value(164, "h323Gatekeeper")
  val H323Proxy = Value(165, "h323Proxy")
  val Mpls = Value(166, "mpls")
  val MfSigLink = Value(167, "mfSigLink")
  val Hdsl2 = Value(168, "hdsl2")
  val Shdsl = Value(169, "shdsl")
  val Ds1FDL = Value(170, "ds1FDL")
  val Pos = Value(171, "pos")
  val DvbAsiIn = Value(172, "dvbAsiIn")
  val DvbAsiOut = Value(173, "dvbAsiOut")
  val Plc = Value(174, "plc")
  val Nfas = Value(175, "nfas")
  val Tr008 = Value(176, "tr008")
  val Gr303RDT = Value(177, "gr303RDT")
  val Gr303IDT = Value(178, "gr303IDT")
  val Isup = Value(179, "isup")
  val PropDocsWirelessMaclayer = Value(180, "propDocsWirelessMaclayer")
  val PropDocsWirelessDownstream = Value(181, "propDocsWirelessDownstream")
  val PropDocsWirelessUpstream = Value(182, "propDocsWirelessUpstream")
  val Hiperlan2 = Value(183, "hiperlan2")
  val PropBWAp2Mp = Value(184, "propBWAp2Mp")
  val SonetOverheadChannel = Value(185, "sonetOverheadChannel")
  val DigitalWrapperOverheadChannel = Value(186, "digitalWrapperOverheadChannel")
  val Aal2 = Value(187, "aal2")
  val RadioMAC = Value(188, "radioMAC")
  val AtmRadio = Value(189, "atmRadio")
  val Imt = Value(190, "imt")
  val Mvl = Value(191, "mvl")
  val ReachDSL = Value(192, "reachDSL")
  val FrDlciEndPt = Value(193, "frDlciEndPt")
  val AtmVciEndPt = Value(194, "atmVciEndPt")
  val OpticalChannel = Value(195, "opticalChannel")
  val OpticalTransport = Value(196, "opticalTransport")
  val PropAtm = Value(197, "propAtm")
  val VoiceOverCable = Value(198, "voiceOverCable")
  val Infiniband = Value(199, "infiniband")
  val TeLink = Value(200, "teLink")
  val Q2931 = Value(201, "q2931")
  val VirtualTg = Value(202, "virtualTg")
  val SipTg = Value(203, "sipTg")
  val SipSig = Value(204, "sipSig")
  val DocsCableUpstreamChannel = Value(205, "docsCableUpstreamChannel")
  val Econet = Value(206, "econet")
  val Pon155 = Value(207, "pon155")
  val Pon622 = Value(208, "pon622")
  val Bridge = Value(209, "bridge")
  val Linegroup = Value(210, "linegroup")
  val VoiceEMFGD = Value(211, "voiceEMFGD")
  val VoiceFGDEANA = Value(212, "voiceFGDEANA")
  val VoiceDID = Value(213, "voiceDID")
  val MpegTransport = Value(214, "mpegTransport")
  val SixToFour = Value(215, "sixToFour")
  val Gtp = Value(216, "gtp")
  val PdnEtherLoop1 = Value(217, "pdnEtherLoop1")
  val PdnEtherLoop2 = Value(218, "pdnEtherLoop2")
  val OpticalChannelGroup = Value(219, "opticalChannelGroup")
  val Homepna = Value(220, "homepna")
  val Gfp = Value(221, "gfp")
  val CiscoISLvlan = Value(222, "ciscoISLvlan")
  val ActelisMetaLOOP = Value(223, "actelisMetaLOOP")
  val FcipLink = Value(224, "fcipLink")
  val Rpr = Value(225, "rpr")
  val Qam = Value(226, "qam")
  val Lmp = Value(227, "lmp")
  val CblVectaStar = Value(228, "cblVectaStar")
  val DocsCableMCmtsDownstream = Value(229, "docsCableMCmtsDownstream")
  val Adsl2 = Value(230, "adsl2")
  val MacSecControlledIF = Value(231, "macSecControlledIF")
  val MacSecUncontrolledIF = Value(232, "macSecUncontrolledIF")
  val AviciOpticalEther = Value(233, "aviciOpticalEther")
  val Atmbond = Value(234, "atmbond")
  val VoiceFGDOS = Value(235, "voiceFGDOS")
  val MocaVersion1 = Value(236, "mocaVersion1")
  val Ieee80216WMAN = Value(237, "ieee80216WMAN")
  val Adsl2plus = Value(238, "adsl2plus")
  val DvbRcsMacLayer = Value(239, "dvbRcsMacLayer")
  val DvbTdm = Value(240, "dvbTdm")
  val DvbRcsTdma = Value(241, "dvbRcsTdma")
  val X86Laps = Value(242, "x86Laps")
  val WwanPP = Value(243, "wwanPP")
  val WwanPP2 = Value(244, "wwanPP2")
}
case object IfType extends AccessibleObject[ReadOnly, IfType_enum.Value](Seq(1,3,6,1,2,1,2,2,1,3), "ifType", IntegerSyntax, Some(IfType_enum))
case object IfMtu extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,4), "ifMtu", IntegerSyntax)
case object IfSpeed extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,5), "ifSpeed", IntegerSyntax)
case object IfPhysAddress extends AccessibleObject[ReadOnly, String](Seq(1,3,6,1,2,1,2,2,1,6), "ifPhysAddress", OctetStringSyntax)
object IfAdminStatus_enum extends EnumInteger {
  type IfAdminStatus = Value
  val Up = Value(1, "up")
  val Down = Value(2, "down")
  val Testing = Value(3, "testing")
}
case object IfAdminStatus extends AccessibleObject[ReadWrite, IfAdminStatus_enum.Value](Seq(1,3,6,1,2,1,2,2,1,7), "ifAdminStatus", IntegerSyntax, Some(IfAdminStatus_enum))
object IfOperStatus_enum extends EnumInteger {
  type IfOperStatus = Value
  val Up = Value(1, "up")
  val Down = Value(2, "down")
  val Testing = Value(3, "testing")
  val Unknown = Value(4, "unknown")
  val Dormant = Value(5, "dormant")
  val NotPresent = Value(6, "notPresent")
  val LowerLayerDown = Value(7, "lowerLayerDown")
}
case object IfOperStatus extends AccessibleObject[ReadOnly, IfOperStatus_enum.Value](Seq(1,3,6,1,2,1,2,2,1,8), "ifOperStatus", IntegerSyntax, Some(IfOperStatus_enum))
case object IfLastChange extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,9), "ifLastChange", IntegerSyntax)
case object IfInOctets extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,10), "ifInOctets", IntegerSyntax)
case object IfInUcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,11), "ifInUcastPkts", IntegerSyntax)
case object IfInNUcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,12), "ifInNUcastPkts", IntegerSyntax)
case object IfInDiscards extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,13), "ifInDiscards", IntegerSyntax)
case object IfInErrors extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,14), "ifInErrors", IntegerSyntax)
case object IfInUnknownProtos extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,15), "ifInUnknownProtos", IntegerSyntax)
case object IfOutOctets extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,16), "ifOutOctets", IntegerSyntax)
case object IfOutUcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,17), "ifOutUcastPkts", IntegerSyntax)
case object IfOutNUcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,18), "ifOutNUcastPkts", IntegerSyntax)
case object IfOutDiscards extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,19), "ifOutDiscards", IntegerSyntax)
case object IfOutErrors extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,20), "ifOutErrors", IntegerSyntax)
case object IfOutQLen extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,21), "ifOutQLen", IntegerSyntax)
case object IfSpecific extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,2,2,1,22), "ifSpecific", ObjectIdentifierSyntax)
case object IfName extends AccessibleObject[ReadOnly, String](Seq(1,3,6,1,2,1,31,1,1,1,1), "ifName", OctetStringSyntax)
case object IfInMulticastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,2), "ifInMulticastPkts", IntegerSyntax)
case object IfInBroadcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,3), "ifInBroadcastPkts", IntegerSyntax)
case object IfOutMulticastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,4), "ifOutMulticastPkts", IntegerSyntax)
case object IfOutBroadcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,5), "ifOutBroadcastPkts", IntegerSyntax)
case object IfHCInOctets extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,6), "ifHCInOctets", IntegerSyntax)
case object IfHCInUcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,7), "ifHCInUcastPkts", IntegerSyntax)
case object IfHCInMulticastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,8), "ifHCInMulticastPkts", IntegerSyntax)
case object IfHCInBroadcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,9), "ifHCInBroadcastPkts", IntegerSyntax)
case object IfHCOutOctets extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,10), "ifHCOutOctets", IntegerSyntax)
case object IfHCOutUcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,11), "ifHCOutUcastPkts", IntegerSyntax)
case object IfHCOutMulticastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,12), "ifHCOutMulticastPkts", IntegerSyntax)
case object IfHCOutBroadcastPkts extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,13), "ifHCOutBroadcastPkts", IntegerSyntax)
object IfLinkUpDownTrapEnable_enum extends EnumInteger {
  type IfLinkUpDownTrapEnable = Value
  val Enabled = Value(1, "enabled")
  val Disabled = Value(2, "disabled")
}
case object IfLinkUpDownTrapEnable extends AccessibleObject[ReadWrite, IfLinkUpDownTrapEnable_enum.Value](Seq(1,3,6,1,2,1,31,1,1,1,14), "ifLinkUpDownTrapEnable", IntegerSyntax, Some(IfLinkUpDownTrapEnable_enum))
case object IfHighSpeed extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,15), "ifHighSpeed", IntegerSyntax)
object IfPromiscuousMode_enum extends EnumInteger {
  type IfPromiscuousMode = Value
  val True = Value(1, "true")
  val False = Value(2, "false")
}
case object IfPromiscuousMode extends AccessibleObject[ReadWrite, IfPromiscuousMode_enum.Value](Seq(1,3,6,1,2,1,31,1,1,1,16), "ifPromiscuousMode", IntegerSyntax, Some(IfPromiscuousMode_enum))
object IfConnectorPresent_enum extends EnumInteger {
  type IfConnectorPresent = Value
  val True = Value(1, "true")
  val False = Value(2, "false")
}
case object IfConnectorPresent extends AccessibleObject[ReadOnly, IfConnectorPresent_enum.Value](Seq(1,3,6,1,2,1,31,1,1,1,17), "ifConnectorPresent", IntegerSyntax, Some(IfConnectorPresent_enum))
case object IfAlias extends AccessibleObject[ReadWrite, String](Seq(1,3,6,1,2,1,31,1,1,1,18), "ifAlias", OctetStringSyntax)
case object IfCounterDiscontinuityTime extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,1,1,19), "ifCounterDiscontinuityTime", IntegerSyntax)
case object IfStackHigherLayer extends AccessibleObject[NotAccessible, Int](Seq(1,3,6,1,2,1,31,1,2,1,1), "ifStackHigherLayer", IntegerSyntax)
case object IfStackLowerLayer extends AccessibleObject[NotAccessible, Int](Seq(1,3,6,1,2,1,31,1,2,1,2), "ifStackLowerLayer", IntegerSyntax)
object IfStackStatus_enum extends EnumInteger {
  type IfStackStatus = Value
  val Active = Value(1, "active")
  val NotInService = Value(2, "notInService")
  val NotReady = Value(3, "notReady")
  val CreateAndGo = Value(4, "createAndGo")
  val CreateAndWait = Value(5, "createAndWait")
  val Destroy = Value(6, "destroy")
}
case object IfStackStatus extends AccessibleObject[ReadCreate, IfStackStatus_enum.Value](Seq(1,3,6,1,2,1,31,1,2,1,3), "ifStackStatus", IntegerSyntax, Some(IfStackStatus_enum))
case object IfStackLastChange extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,6), "ifStackLastChange", IntegerSyntax) with Scalar[ReadOnly, Int]
case object IfRcvAddressAddress extends AccessibleObject[NotAccessible, String](Seq(1,3,6,1,2,1,31,1,4,1,1), "ifRcvAddressAddress", OctetStringSyntax)
object IfRcvAddressStatus_enum extends EnumInteger {
  type IfRcvAddressStatus = Value
  val Active = Value(1, "active")
  val NotInService = Value(2, "notInService")
  val NotReady = Value(3, "notReady")
  val CreateAndGo = Value(4, "createAndGo")
  val CreateAndWait = Value(5, "createAndWait")
  val Destroy = Value(6, "destroy")
}
case object IfRcvAddressStatus extends AccessibleObject[ReadCreate, IfRcvAddressStatus_enum.Value](Seq(1,3,6,1,2,1,31,1,4,1,2), "ifRcvAddressStatus", IntegerSyntax, Some(IfRcvAddressStatus_enum))
object IfRcvAddressType_enum extends EnumInteger {
  type IfRcvAddressType = Value
  val Other = Value(1, "other")
  val Volatile = Value(2, "volatile")
  val NonVolatile = Value(3, "nonVolatile")
}
case object IfRcvAddressType extends AccessibleObject[ReadCreate, IfRcvAddressType_enum.Value](Seq(1,3,6,1,2,1,31,1,4,1,3), "ifRcvAddressType", IntegerSyntax, Some(IfRcvAddressType_enum))













case object IfTestId extends AccessibleObject[ReadWrite, Int](Seq(1,3,6,1,2,1,31,1,3,1,1), "ifTestId", IntegerSyntax)
object IfTestStatus_enum extends EnumInteger {
  type IfTestStatus = Value
  val NotInUse = Value(1, "notInUse")
  val InUse = Value(2, "inUse")
}
case object IfTestStatus extends AccessibleObject[ReadWrite, IfTestStatus_enum.Value](Seq(1,3,6,1,2,1,31,1,3,1,2), "ifTestStatus", IntegerSyntax, Some(IfTestStatus_enum))
case object IfTestType extends AccessibleObject[ReadWrite, Int](Seq(1,3,6,1,2,1,31,1,3,1,3), "ifTestType", ObjectIdentifierSyntax)
object IfTestResult_enum extends EnumInteger {
  type IfTestResult = Value
  val None = Value(1, "none")
  val Success = Value(2, "success")
  val InProgress = Value(3, "inProgress")
  val NotSupported = Value(4, "notSupported")
  val UnAbleToRun = Value(5, "unAbleToRun")
  val Aborted = Value(6, "aborted")
  val Failed = Value(7, "failed")
}
case object IfTestResult extends AccessibleObject[ReadOnly, IfTestResult_enum.Value](Seq(1,3,6,1,2,1,31,1,3,1,4), "ifTestResult", IntegerSyntax, Some(IfTestResult_enum))
case object IfTestCode extends AccessibleObject[ReadOnly, Int](Seq(1,3,6,1,2,1,31,1,3,1,5), "ifTestCode", ObjectIdentifierSyntax)
case object IfTestOwner extends AccessibleObject[ReadWrite, String](Seq(1,3,6,1,2,1,31,1,3,1,6), "ifTestOwner", OctetStringSyntax)






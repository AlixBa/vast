package com.github.alixba.vast

import scala.xml.Node

case class WrapperLinear(creativeExtensions: Option[Seq[CreativeExtension]], icons: Option[Seq[Icon]],
                         trackingEvents: Option[Seq[Tracking]], videoClicks: Option[WrapperVideoClicks])
    extends Linear with WrapperCreativeElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val creativeExtensionsXML = creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(_.toXML) }</CreativeExtensions>).toSeq
    val iconsXML = icons.map(n ⇒ <Icons>{ n.map(_.toXML) }</Icons>).toSeq
    val trackingEventsXML = trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(_.toXML) }</TrackingEvents>).toSeq
    val videoClicksXML = videoClicks.map(_.toXML).toSeq

    <Linear>{ creativeExtensionsXML }{ iconsXML }{ trackingEventsXML }{ videoClicksXML }</Linear>
  }

}

object WrapperLinear extends VASTElementCompanion[WrapperLinear] {

  /**
   * Deserializes a Node to a T.
   * The highest tag of the Node should match
   * the T.
   *
   * {{{
   *   val elem = <Ad><SomeTags/></Ad>
   *   val ad = Ad.fromXML(elem)
   * }}}
   */
  def fromXML(node: Node): WrapperLinear = {
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").map(CreativeExtension.fromXML))
    val icons = (node \ "Icons").headOption.map(n ⇒ (n \ "Icon").map(Icon.fromXML))
    val trackingEvents = (node \ "TrackingEvents").headOption.map(n ⇒ (n \ "Tracking").map(Tracking.fromXML))
    val videoClicks = (node \ "VideoClicks").headOption.map(WrapperVideoClicks.fromXML)

    WrapperLinear(creativeExtensions, icons, trackingEvents, videoClicks)
  }

}
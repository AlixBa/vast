package com.example.vast

import scala.xml.Node

case class WrapperLinear(icons: Option[Seq[Icon]], creativeExtensions: Option[Seq[CreativeExtension]],
                         trackingEvents: Option[Seq[Tracking]], videoClicks: Option[WrapperVideoClicks])
    extends WrapperCreativeElement

object WrapperLinear extends VASTElement[WrapperLinear] {

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
    val icons = (node \ "Icons").headOption.map(n ⇒ (n \ "Icon").toSeq.map(Icon.fromXML))
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").toSeq.map(CreativeExtension.fromXML))
    val trackingEvents = (node \ "TrackingEvents")
      .headOption.map(n ⇒ (n \ "Tracking").toSeq.map(Tracking.fromXML))
    val videoClicks = (node \ "VideoClicks").headOption.map(WrapperVideoClicks.fromXML)

    WrapperLinear(icons, creativeExtensions, trackingEvents, videoClicks)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: WrapperLinear): Node = {
    val iconsXML = t.icons.map(n ⇒ <Icons>{ n.map(Icon.toXML) }</Icons>).toSeq
    val creativeExtensionsXML = t.creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(CreativeExtension.toXML) }</CreativeExtensions>).toSeq
    val trackingEventsXML = t.trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(Tracking.toXML) }</TrackingEvents>).toSeq
    val videoClicksXML = t.videoClicks.map(WrapperVideoClicks.toXML).toSeq

    <Linear>{ iconsXML }{ creativeExtensionsXML }{ trackingEventsXML }{ videoClicksXML }</Linear>
  }

}
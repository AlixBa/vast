package alixba.vast

import scala.xml.Node

case class WrapperLinear(icons: Option[Seq[Icon]], creativeExtensions: Option[Seq[CreativeExtension]],
                         trackingEvents: Option[Seq[Tracking]], videoClicks: Option[WrapperVideoClicks])
    extends Linear[WrapperLinear] with WrapperCreativeElement {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node = {
    val iconsXML = icons.map(n ⇒ <Icons>{ n.map(_.toXML) }</Icons>).toSeq
    val creativeExtensionsXML = creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(_.toXML) }</CreativeExtensions>).toSeq
    val trackingEventsXML = trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(_.toXML) }</TrackingEvents>).toSeq
    val videoClicksXML = videoClicks.map(_.toXML).toSeq

    <Linear>{ iconsXML }{ creativeExtensionsXML }{ trackingEventsXML }{ videoClicksXML }</Linear>
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
    val icons = (node \ "Icons").headOption.map(n ⇒ (n \ "Icon").toSeq.map(Icon.fromXML))
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").toSeq.map(CreativeExtension.fromXML))
    val trackingEvents = (node \ "TrackingEvents")
      .headOption.map(n ⇒ (n \ "Tracking").toSeq.map(Tracking.fromXML))
    val videoClicks = (node \ "VideoClicks").headOption.map(WrapperVideoClicks.fromXML)

    WrapperLinear(icons, creativeExtensions, trackingEvents, videoClicks)
  }

}
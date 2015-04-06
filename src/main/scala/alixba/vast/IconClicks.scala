package alixba.vast

import scala.xml.Node

case class IconClicks(iconClicksTracking: Seq[IconClickTracking], iconClickThrough: Option[IconClickThrough])
    extends VASTElement[IconClicks] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node = {
    val iconClicksTrackingXML = iconClicksTracking.map(_.toXML)
    val iconClickThroughXML = iconClickThrough.map(_.toXML).toSeq

    <IconClicks>{ iconClicksTrackingXML }{ iconClickThroughXML }</IconClicks>
  }

}

object IconClicks extends VASTElementCompanion[IconClicks] {

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
  def fromXML(node: Node): IconClicks = {
    val iconClicksTracking = (node \ "IconClickTracking").toSeq.map(IconClickTracking.fromXML)
    val iconClickThrough = (node \ "IconClickThrough").headOption.map(IconClickThrough.fromXML)

    IconClicks(iconClicksTracking, iconClickThrough)
  }

}
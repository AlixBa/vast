package alixba.vast

import scala.xml.Node

case class WrapperVideoClicks(clicksTracking: Seq[ClickTracking], customClicks: Seq[CustomClick])
    extends VideoClicks[WrapperVideoClicks] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node = {
    val clickTrackingXML = clicksTracking.map(_.toXML)
    val customClicksXML = customClicks.map(_.toXML)

    <VideoClicks>{ clickTrackingXML }{ customClicksXML }</VideoClicks>
  }

}

object WrapperVideoClicks extends VASTElementCompanion[WrapperVideoClicks] {

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
  def fromXML(node: Node): WrapperVideoClicks = {
    val clickTracking = (node \ "ClickTracking").toSeq.map(ClickTracking.fromXML)
    val customClicks = (node \ "CustomClick").toSeq.map(CustomClick.fromXML)

    WrapperVideoClicks(clickTracking, customClicks)
  }

}

package com.example.vast

import scala.xml.Node

case class WrapperVideoClicks(clicksTracking: Seq[ClickTracking], customClicks: Seq[CustomClick])

object WrapperVideoClicks extends VASTElement[WrapperVideoClicks] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: WrapperVideoClicks): Node = {
    val clickTrackingXML = t.clicksTracking.map(ClickTracking.toXML)
    val customClicksXML = t.customClicks.map(CustomClick.toXML)

    <VideoClicks>{ clickTrackingXML }{ customClicksXML }</VideoClicks>
  }

}

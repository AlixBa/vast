package com.example.vast

import scala.xml.Node

case class InLineVideoClicks(clickThrough: Option[ClickThrough], clicksTracking: Seq[ClickTracking],
                             customClicks: Seq[CustomClick])

object InLineVideoClicks extends VASTElement[InLineVideoClicks] {

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
  def fromXML(node: Node): InLineVideoClicks = {
    val clickThrough = (node \ "ClickThrough").headOption.map(ClickThrough.fromXML)
    val clickTracking = (node \ "ClickTracking").toSeq.map(ClickTracking.fromXML)
    val customClicks = (node \ "CustomClick").toSeq.map(CustomClick.fromXML)

    InLineVideoClicks(clickThrough, clickTracking, customClicks)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineVideoClicks): Node = {
    val clickThroughXML = t.clickThrough.map(ClickThrough.toXML).toSeq
    val clickTrackingXML = t.clicksTracking.map(ClickTracking.toXML)
    val customClicksXML = t.customClicks.map(CustomClick.toXML)

    <VideoClicks>{ clickThroughXML }{ clickTrackingXML }{ customClicksXML }</VideoClicks>
  }

}
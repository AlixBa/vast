package com.github.alixba.vast

import scala.xml.Node

case class WrapperVideoClicks(clickThrough: Option[ClickThrough], clicksTracking: Seq[ClickTracking],
                              customClicks: Seq[CustomClick]) extends VideoClicks {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val clickThroughXML = clickThrough.map(_.toXML).toSeq
    val clickTrackingXML = clicksTracking.map(_.toXML)
    val customClicksXML = customClicks.map(_.toXML)

    <VideoClicks>{ clickThroughXML }{ clickTrackingXML }{ customClicksXML }</VideoClicks>
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
    val clickThrough = (node \ "ClickThrough").headOption.map(ClickThrough.fromXML)
    val clickTracking = (node \ "ClickTracking").map(ClickTracking.fromXML)
    val customClicks = (node \ "CustomClick").map(CustomClick.fromXML)

    WrapperVideoClicks(clickThrough, clickTracking, customClicks)
  }

}

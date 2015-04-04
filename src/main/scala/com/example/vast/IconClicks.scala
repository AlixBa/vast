package com.example.vast

import scala.xml.Node

case class IconClicks(iconClicksTracking: Seq[IconClickTracking], iconClickThrough: Option[IconClickThrough])

object IconClicks extends VASTElement[IconClicks] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: IconClicks): Node = {
    val iconClicksTrackingXML = t.iconClicksTracking.map(IconClickTracking.toXML)
    val iconClickThroughXML = t.iconClickThrough.map(IconClickThrough.toXML).toSeq

    <IconClicks>{ iconClicksTrackingXML }{ iconClickThroughXML }</IconClicks>
  }

}
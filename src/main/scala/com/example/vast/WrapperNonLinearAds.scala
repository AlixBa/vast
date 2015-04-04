package com.example.vast

import scala.xml.Node

case class WrapperNonLinearAds(trackingEvents: Option[Seq[Tracking]], nonLinears: Seq[WrapperNonLinear])
  extends WrapperCreativeElement

object WrapperNonLinearAds extends VASTElement[WrapperNonLinearAds] {

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
  def fromXML(node: Node): WrapperNonLinearAds = {
    val trackingEvents = (node \ "TrackingEvents").headOption.map(n ⇒ (n \ "Tracking").toSeq.map(Tracking.fromXML))
    val nonLinears = (node \ "NonLinear").toSeq.map(WrapperNonLinear.fromXML)

    WrapperNonLinearAds(trackingEvents, nonLinears)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: WrapperNonLinearAds): Node = {
    val trackingEventsXML = t.trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(Tracking.toXML) }</TrackingEvents>).toSeq
    val nonLinears = t.nonLinears.map(WrapperNonLinear.toXML)

    <NonLinearAds>{ trackingEventsXML }{ nonLinears }</NonLinearAds>
  }

}
package com.example.vast

import scala.xml.Node

case class InLineNonLinearAds(trackingEvents: Option[Seq[Tracking]], nonLinears: Seq[InLineNonLinear])
  extends InLineCreativeElement

object InLineNonLinearAds extends VASTElement[InLineNonLinearAds] {

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
  def fromXML(node: Node): InLineNonLinearAds = {
    val trackingEvents = (node \ "TrackingEvents").headOption.map(n ⇒ (n \ "Tracking").toSeq.map(Tracking.fromXML))
    val nonLinears = (node \ "NonLinear").toSeq.map(InLineNonLinear.fromXML)

    InLineNonLinearAds(trackingEvents, nonLinears)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineNonLinearAds): Node = {
    val trackingEventsXML = t.trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(Tracking.toXML) }</TrackingEvents>).toSeq
    val nonLinears = t.nonLinears.map(InLineNonLinear.toXML)

    <NonLinearAds>{ trackingEventsXML }{ nonLinears }</NonLinearAds>
  }

}
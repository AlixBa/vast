package com.github.alixba.vast

import scala.xml.Node

case class InLineNonLinearAds(trackingEvents: Option[Seq[Tracking]], nonLinears: Seq[InLineNonLinear])
    extends NonLinearAds with InLineCreativeElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val trackingEventsXML = trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(_.toXML) }</TrackingEvents>).toSeq
    val nonLinearsXML = nonLinears.map(_.toXML)

    <NonLinearAds>{ trackingEventsXML }{ nonLinearsXML }</NonLinearAds>
  }

}

object InLineNonLinearAds extends VASTElementCompanion[InLineNonLinearAds] {

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
    val trackingEvents = (node \ "TrackingEvents").headOption.map(n ⇒ (n \ "Tracking").map(Tracking.fromXML))
    val nonLinears = (node \ "NonLinear").map(InLineNonLinear.fromXML)

    InLineNonLinearAds(trackingEvents, nonLinears)
  }

}
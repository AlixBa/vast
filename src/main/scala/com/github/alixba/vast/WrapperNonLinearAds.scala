package com.github.alixba.vast

import scala.xml.Node

case class WrapperNonLinearAds(trackingEvents: Option[Seq[Tracking]], nonLinears: Seq[WrapperNonLinear])
    extends NonLinearAds with WrapperCreativeElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val trackingEventsXML = trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(_.toXML) }</TrackingEvents>).toSeq
    val nonLinearsXML = nonLinears.map(_.toXML)

    <NonLinearAds>{ trackingEventsXML }{ nonLinearsXML }</NonLinearAds>
  }

}

object WrapperNonLinearAds extends VASTElementCompanion[WrapperNonLinearAds] {

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

}
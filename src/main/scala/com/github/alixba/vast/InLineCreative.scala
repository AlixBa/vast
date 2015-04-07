package com.github.alixba.vast

import scala.xml.Node

case class InLineCreative(element: InLineCreativeElement, id: Option[String], sequence: Option[Int],
                          AdID: Option[String]) extends Creative {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Creative id={ id } sequence={ sequence } AdID={ AdID }>{ element.toXML }</Creative>

}

object InLineCreative extends VASTElementCompanion[InLineCreative] {

  def apply(element: InLineCreativeElement): InLineCreative =
    InLineCreative(element, None, None, None)

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
  def fromXML(node: Node): InLineCreative = {
    val element = InLineCreativeElement.fromXML(node)
    val id = (node \ "@id").headOption
    val sequence = (node \ "@sequence").headOption
    val adID = (node \ "@AdID").headOption

    InLineCreative(element, id, sequence, adID)
  }

}

trait InLineCreativeElement extends CreativeElement

object InLineCreativeElement extends VASTElementCompanion[InLineCreativeElement] {

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
  def fromXML(node: Node): InLineCreativeElement = {
    val linear = (node \ "Linear").headOption.map(InLineLinear.fromXML)
    val companionAds = (node \ "CompanionAds").headOption.map(InLineCompanionAds.fromXML)
    val nonLinearAds = (node \ "NonLinearAds").headOption.map(InLineNonLinearAds.fromXML)

    linear.getOrElse(
      companionAds.getOrElse(
        nonLinearAds.getOrElseMissingException("Linear", "CompanionAds", "NonLinearAds")
      )
    )
  }

}
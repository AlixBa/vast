package com.example.vast

import scala.xml.Node

case class InLineCreative(element: InLineCreativeElement, id: Option[String], sequence: Option[Int],
                          AdID: Option[String])

object InLineCreative extends VASTElement[InLineCreative] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineCreative): Node = {
    val elementXML = InLineCreativeElement.toXML(t.element)

    <Creative id={ t.id } sequence={ t.sequence } AdID={ t.AdID }>{ elementXML }</Creative>
  }

}

trait InLineCreativeElement

object InLineCreativeElement extends VASTElement[InLineCreativeElement] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineCreativeElement): Node = {
    t match {
      case l @ InLineLinear(_, _, _, _, _, _, _, _) ⇒ InLineLinear.toXML(l)
      case c @ InLineCompanionAds(_, _)             ⇒ InLineCompanionAds.toXML(c)
      case n @ InLineNonLinearAds(_, _)             ⇒ InLineNonLinearAds.toXML(n)
    }
  }

}
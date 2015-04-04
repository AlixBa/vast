package com.example.vast

import scala.xml.Node

case class WrapperCreative(element: WrapperCreativeElement, id: Option[String], sequence: Option[Int],
                           AdID: Option[String])

object WrapperCreative extends VASTElement[WrapperCreative] {

  def apply(element: WrapperCreativeElement): WrapperCreative =
    WrapperCreative(element, None, None, None)

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
  def fromXML(node: Node): WrapperCreative = {
    val element = WrapperCreativeElement.fromXML(node)
    val id = (node \ "@id").headOption
    val sequence = (node \ "@sequence").headOption
    val adID = (node \ "@AdID").headOption

    WrapperCreative(element, id, sequence, adID)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: WrapperCreative): Node = {
    val elementXML = WrapperCreativeElement.toXML(t.element)

    <Creative id={ t.id } sequence={ t.sequence } AdID={ t.AdID }>{ elementXML }</Creative>
  }

}

trait WrapperCreativeElement

object WrapperCreativeElement extends VASTElement[WrapperCreativeElement] {

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
  def fromXML(node: Node): WrapperCreativeElement = {
    val linear = (node \ "Linear").headOption.map(WrapperLinear.fromXML)
    val companionAds = (node \ "CompanionAds").headOption.map(WrapperCompanionAds.fromXML)
    val nonLinearAds = (node \ "NonLinearAds").headOption.map(WrapperNonLinearAds.fromXML)

    linear.getOrElse(
      companionAds.getOrElse(
        nonLinearAds.getOrElseMissingException("Linear", "CompanionAds", "NonLinearAds")
      )
    )
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: WrapperCreativeElement): Node = {
    t match {
      case l @ WrapperLinear(_, _, _, _) ⇒ WrapperLinear.toXML(l)
      case c @ WrapperCompanionAds(_)    ⇒ WrapperCompanionAds.toXML(c)
      case n @ WrapperNonLinearAds(_, _) ⇒ WrapperNonLinearAds.toXML(n)
    }
  }

}
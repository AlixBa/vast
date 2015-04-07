package alixba.vast

import scala.xml.Node

case class WrapperCreative(element: WrapperCreativeElement, id: Option[String], sequence: Option[Int],
                           AdID: Option[String]) extends Creative {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Creative id={ id } sequence={ sequence } AdID={ AdID }>{ element.toXML }</Creative>

}

object WrapperCreative extends VASTElementCompanion[WrapperCreative] {

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

}

trait WrapperCreativeElement extends CreativeElement

object WrapperCreativeElement extends VASTElementCompanion[WrapperCreativeElement] {

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

}
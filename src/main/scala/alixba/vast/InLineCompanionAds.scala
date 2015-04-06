package alixba.vast

import scala.xml.Node

case class InLineCompanionAds(companions: Seq[InLineCompanion], required: Option[Required])
    extends CompanionAds[InLineCompanionAds] with InLineCreativeElement {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node = {
    val companionsXML = companions.map(_.toXML)
    val requiredXML = required.map(_.toString)

    <CompanionAds required={ requiredXML }>{ companionsXML }</CompanionAds>
  }

}

object InLineCompanionAds extends VASTElementCompanion[InLineCompanionAds] {

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
  def fromXML(node: Node): InLineCompanionAds = {
    val companions = (node \ "Companion").toSeq.map(InLineCompanion.fromXML)
    val required = (node \ "@required").headOption.map(n ⇒ Required.fromString(n.text))

    InLineCompanionAds(companions, required)
  }

}
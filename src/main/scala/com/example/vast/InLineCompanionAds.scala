package com.example.vast

import scala.xml.Node

case class InLineCompanionAds(companions: Seq[InLineCompanion], required: Option[Required]) extends InLineCreativeElement

object InLineCompanionAds extends VASTElement[InLineCompanionAds] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineCompanionAds): Node = {
    val companionsXML = t.companions.map(InLineCompanion.toXML)
    val requiredXML = t.required.map(_.toString)

    <CompanionAds required={ requiredXML }>{ companionsXML }</CompanionAds>
  }

}
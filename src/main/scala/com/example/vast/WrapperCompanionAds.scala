package com.example.vast

import scala.xml.Node

case class WrapperCompanionAds(companions: Seq[WrapperCompanion]) extends WrapperCreativeElement

object WrapperCompanionAds extends VASTElement[WrapperCompanionAds] {

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
  def fromXML(node: Node): WrapperCompanionAds = {
    val companions = (node \ "Companion").toSeq.map(WrapperCompanion.fromXML)

    WrapperCompanionAds(companions)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: WrapperCompanionAds): Node = {
    val companionsXML = t.companions.map(WrapperCompanion.toXML)

    <CompanionAds>{ companionsXML }</CompanionAds>
  }

}
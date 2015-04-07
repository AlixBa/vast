package com.github.alixba.vast

import scala.xml.Node

case class WrapperCompanionAds(companions: Seq[WrapperCompanion]) extends CompanionAds with WrapperCreativeElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val companionsXML = companions.map(_.toXML)

    <CompanionAds>{ companionsXML }</CompanionAds>
  }

}

object WrapperCompanionAds extends VASTElementCompanion[WrapperCompanionAds] {

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

}
package com.example.vast

import scala.xml.Node

case class VAST(version: String, ads: Seq[Ad])

object VAST extends VASTElement[VAST] {

  def apply(version: String): VAST =
    VAST(version, Seq.empty)

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
  def fromXML(node: Node): VAST = {
    val ads = (node \ "Ad").toSeq.map(Ad.fromXML)
    val version = (node \ "@version").headOption.getOrElseMissingException("version")

    VAST(version, ads)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: VAST): Node = {
    val adsXML = t.ads.map(Ad.toXML)

    <VAST version={ t.version }>{ adsXML }</VAST>
  }

}
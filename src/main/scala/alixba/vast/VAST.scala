package alixba.vast

import scala.xml.Node

case class VAST(version: String, ads: Seq[Ad]) extends VASTElement[VAST] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node = {
    val adsXML = ads.map(_.toXML)

    <VAST version={ version }>{ adsXML }</VAST>
  }

}

object VAST extends VASTElementCompanion[VAST] {

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

}
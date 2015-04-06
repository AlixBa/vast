package alixba.vast

import scala.xml.Node

case class AdSystem(value: String, version: Option[String]) extends VASTElement[AdSystem] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <AdSystem version={ version }>{ value }</AdSystem>

}

object AdSystem extends VASTElementCompanion[AdSystem] {

  def apply(value: String): AdSystem =
    AdSystem(value, None)

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
  def fromXML(node: Node): AdSystem = {
    val value = node.text
    val version = (node \ "@version").headOption

    AdSystem(value, version)
  }

}
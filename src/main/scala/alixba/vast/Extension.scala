package alixba.vast

import scala.xml._

case class Extension(nodes: Seq[Node], attributes: Map[String, String]) extends VASTElement[Extension] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <Extension>{ nodes }</Extension> % attributes.asMetaData

}

object Extension extends VASTElementCompanion[Extension] {

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
  def fromXML(node: Node): Extension =
    Extension(node.child, node.attributes.asAttrMap)

}
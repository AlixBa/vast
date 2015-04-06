package alixba.vast

import scala.xml._

case class Extension(nodes: Seq[Node], attributes: Map[String, String])

object Extension extends VASTElement[Extension] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Extension): Node =
    <Extension>{ t.nodes }</Extension> % t.attributes.asMetaData

}
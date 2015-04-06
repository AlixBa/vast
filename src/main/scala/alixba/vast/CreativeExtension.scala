package alixba.vast

import scala.xml.Node

case class CreativeExtension(nodes: Seq[Node], attributes: Map[String, String])

object CreativeExtension extends VASTElement[CreativeExtension] {

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
  def fromXML(node: Node): CreativeExtension =
    CreativeExtension(node.child, node.attributes.asAttrMap)

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: CreativeExtension): Node =
    <CreativeExtension>{ t.nodes }</CreativeExtension> % t.attributes.asMetaData

}
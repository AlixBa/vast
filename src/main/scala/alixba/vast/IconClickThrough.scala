package alixba.vast

import java.net.URI

import scala.xml.Node

case class IconClickThrough(value: URI) extends VASTElement {
  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <IconClickThrough>{ value.asCData }</IconClickThrough>

}

object IconClickThrough extends VASTElementCompanion[IconClickThrough] {

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
  def fromXML(node: Node): IconClickThrough =
    IconClickThrough(URI.create(node.text))

}
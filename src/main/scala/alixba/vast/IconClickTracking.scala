package alixba.vast

import java.net.URI

import scala.xml.Node

case class IconClickTracking(value: URI) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <IconClickTracking>{ value.asCData }</IconClickTracking>

}

object IconClickTracking extends VASTElementCompanion[IconClickTracking] {

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
  def fromXML(node: Node): IconClickTracking =
    IconClickTracking(URI.create(node.text))

}
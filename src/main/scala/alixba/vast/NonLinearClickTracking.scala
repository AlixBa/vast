package alixba.vast

import java.net.URI

import scala.xml.Node

case class NonLinearClickTracking(value: URI) extends VASTElement[NonLinearClickTracking] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <NonLinearClickTracking>{ value.asCData }</NonLinearClickTracking>

}

object NonLinearClickTracking extends VASTElementCompanion[NonLinearClickTracking] {

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
  def fromXML(node: Node): NonLinearClickTracking =
    NonLinearClickTracking(URI.create(node.text))

}
package alixba.vast

import java.net.URI

import scala.xml.Node

case class NonLinearClickTracking(value: URI)

object NonLinearClickTracking extends VASTElement[NonLinearClickTracking] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: NonLinearClickTracking): Node =
    <NonLinearClickTracking>{ t.value.asCData }</NonLinearClickTracking>

}
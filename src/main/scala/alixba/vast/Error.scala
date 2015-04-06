package alixba.vast

import java.net.URI

import scala.xml.Node

case class Error(value: URI)

object Error extends VASTElement[Error] {

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
  def fromXML(node: Node): Error =
    Error(URI.create(node.text))

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Error): Node =
    <Error>{ t.value.asCData }</Error>

}
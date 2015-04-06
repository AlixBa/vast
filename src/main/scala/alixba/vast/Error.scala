package alixba.vast

import java.net.URI

import scala.xml.Node

case class Error(value: URI) extends VASTElement[Error] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <Error>{ value.asCData }</Error>

}

object Error extends VASTElementCompanion[Error] {

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

}
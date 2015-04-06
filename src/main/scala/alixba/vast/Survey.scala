package alixba.vast

import java.net.URI

import scala.xml.Node

case class Survey(value: URI)

object Survey extends VASTElement[Survey] {
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
  def fromXML(node: Node): Survey =
    Survey(URI.create(node.text))

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Survey): Node =
    <Survey>{ t.value.asCData }</Survey>

}
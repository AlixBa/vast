package alixba.vast

import java.net.URI

import scala.xml.Node

case class Survey(value: URI) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Survey>{ value.asCData }</Survey>

}

object Survey extends VASTElementCompanion[Survey] {
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

}
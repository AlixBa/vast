package alixba.vast

import scala.xml.Node

case class AdTitle(value: String)

object AdTitle extends VASTElement[AdTitle] {

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
  def fromXML(node: Node): AdTitle =
    AdTitle(node.text)

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: AdTitle): Node =
    <AdTitle>{ t.value }</AdTitle>

}
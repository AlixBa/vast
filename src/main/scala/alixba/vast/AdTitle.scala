package alixba.vast

import scala.xml.Node

case class AdTitle(value: String) extends VASTElement[AdTitle] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <AdTitle>{ value }</AdTitle>

}

object AdTitle extends VASTElementCompanion[AdTitle] {

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

}
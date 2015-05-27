package com.github.alixba.vast

import scala.xml.Node

case class NonLinearClickThrough(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <NonLinearClickThrough>{ value.asCData }</NonLinearClickThrough>

}

object NonLinearClickThrough extends VASTElementCompanion[NonLinearClickThrough] {

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
  def fromXML(node: Node): NonLinearClickThrough =
    NonLinearClickThrough(node.text)

}
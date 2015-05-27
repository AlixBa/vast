package com.github.alixba.vast

import scala.xml.Node

case class Error(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
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
    Error(node.text)

}
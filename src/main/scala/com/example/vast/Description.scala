package com.example.vast

import scala.xml.Node

case class Description(value: String)

object Description extends VASTElement[Description] {

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
  def fromXML(node: Node): Description =
    Description(node.text)

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Description): Node =
    <Description>{ t.value }</Description>

}
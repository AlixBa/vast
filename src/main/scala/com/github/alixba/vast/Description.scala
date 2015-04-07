package com.github.alixba.vast

import scala.xml.Node

case class Description(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Description>{ value }</Description>

}

object Description extends VASTElementCompanion[Description] {

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

}
package com.github.alixba.vast

import scala.xml.Node

case class IconClickThrough(value: String) extends VASTElement {
  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <IconClickThrough>{ value.asCData }</IconClickThrough>

}

object IconClickThrough extends VASTElementCompanion[IconClickThrough] {

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
  def fromXML(node: Node): IconClickThrough =
    IconClickThrough(node.text)

}
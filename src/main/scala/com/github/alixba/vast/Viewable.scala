package com.github.alixba.vast

import scala.xml.Node

case class Viewable(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Viewable>{ value.asCData }</Viewable>

}

object Viewable extends VASTElementCompanion[Viewable] {

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
  def fromXML(node: Node): Viewable = {
    val value = node.text

    Viewable(value)
  }

}
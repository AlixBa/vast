package com.github.alixba.vast

import scala.xml.Node

case class NotViewable(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <NotViewable>{ value.asCData }</NotViewable>

}

object NotViewable extends VASTElementCompanion[NotViewable] {

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
  def fromXML(node: Node): NotViewable = {
    val value = node.text

    NotViewable(value)
  }

}
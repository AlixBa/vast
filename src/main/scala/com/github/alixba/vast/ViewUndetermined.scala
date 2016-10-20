package com.github.alixba.vast

import scala.xml.Node

case class ViewUndetermined(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <ViewUndetermined>{ value.asCData }</ViewUndetermined>

}

object ViewUndetermined extends VASTElementCompanion[ViewUndetermined] {

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
  def fromXML(node: Node): ViewUndetermined = {
    val value = node.text

    ViewUndetermined(value)
  }

}
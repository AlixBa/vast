package com.github.alixba.vast

import scala.xml.Node

case class CustomClick(value: String, id: Option[String]) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <CustomClick id={ id }>{ value.asCData }</CustomClick>

}

object CustomClick extends VASTElementCompanion[CustomClick] {

  def apply(value: String): CustomClick =
    CustomClick(value, None)

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
  def fromXML(node: Node): CustomClick = {
    val value = node.text
    val id = (node \ "@id").headOption

    CustomClick(value, id)
  }

}
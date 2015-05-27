package com.github.alixba.vast

import scala.xml.Node

case class Impression(value: String, id: Option[String]) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Impression id={ id }>{ value.asCData }</Impression>

}

object Impression extends VASTElementCompanion[Impression] {

  def apply(value: String): Impression =
    Impression(value, None)

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
  def fromXML(node: Node): Impression = {
    val value = node.text
    val id = (node \ "@id").headOption

    Impression(value, id)
  }

}
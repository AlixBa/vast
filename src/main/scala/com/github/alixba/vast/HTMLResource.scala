package com.github.alixba.vast

import scala.xml.Node

case class HTMLResource(value: String, xmlEncoded: Option[Boolean]) extends Resource {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <HTMLResource xmlEncoded={ xmlEncoded }>{ value }</HTMLResource>

}

object HTMLResource extends VASTElementCompanion[HTMLResource] {

  def apply(value: String): HTMLResource =
    HTMLResource(value, None)

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
  def fromXML(node: Node): HTMLResource = {
    val value = node.text
    val xmlEncoded = (node \ "@xmlEncoded").headOption

    HTMLResource(value, xmlEncoded)
  }

}
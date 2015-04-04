package com.example.vast

import scala.xml.Node

case class HTMLResource(value: String, xmlEncoded: Option[Boolean]) extends IconElement with InLineCompanionElement
  with InLineNonLinearElement with WrapperCompanionElement

object HTMLResource extends VASTElement[HTMLResource] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: HTMLResource): Node =
    <HTMLResource xmlEncoded={ t.xmlEncoded }>{ t.value }</HTMLResource>

}
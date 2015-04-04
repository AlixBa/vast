package com.example.vast

import scala.xml.Node

case class AdParameters(value: String, xmlEncoded: Option[Boolean])

object AdParameters extends VASTElement[AdParameters] {

  def apply(value: String): AdParameters =
    AdParameters(value, None)

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
  def fromXML(node: Node): AdParameters = {
    val value = node.text
    val xmlEncoded = (node \ "@xmlEncoded").headOption

    AdParameters(value, xmlEncoded)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: AdParameters): Node =
    <AdParameters xmlEncoded={ t.xmlEncoded }>{ t.value }</AdParameters>

}
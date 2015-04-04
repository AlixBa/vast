package com.example.vast

import scala.xml.Node

case class AltText(value: String)

object AltText extends VASTElement[AltText] {

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
  def fromXML(node: Node): AltText =
    AltText(node.text)

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: AltText): Node =
    <AltText>{ t.value }</AltText>

}

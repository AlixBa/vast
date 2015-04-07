package com.github.alixba.vast

import scala.xml.Node

case class AltText(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <AltText>{ value }</AltText>

}

object AltText extends VASTElementCompanion[AltText] {

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

}

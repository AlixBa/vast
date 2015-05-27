package com.github.alixba.vast

import scala.xml.Node

case class CompanionClickThrough(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <CompanionClickThrough>{ value.asCData }</CompanionClickThrough>

}

object CompanionClickThrough extends VASTElementCompanion[CompanionClickThrough] {

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
  def fromXML(node: Node): CompanionClickThrough =
    CompanionClickThrough(node.text)

}

package com.example.vast

import java.net.URI

import scala.xml.Node

case class CompanionClickThrough(value: URI)

object CompanionClickThrough extends VASTElement[CompanionClickThrough] {

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
    CompanionClickThrough(URI.create(node.text))

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: CompanionClickThrough): Node =
    <CompanionClickThrough>{ t.value.asCData }</CompanionClickThrough>

}

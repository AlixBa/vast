package com.example.vast

import java.net.URI

import scala.xml.Node

case class CompanionClickTracking(value: URI)

object CompanionClickTracking extends VASTElement[CompanionClickTracking] {

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
  def fromXML(node: Node): CompanionClickTracking =
    CompanionClickTracking(URI.create(node.text))

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: CompanionClickTracking): Node =
    <CompanionClickTracking>{ t.value.asCData }</CompanionClickTracking>

}


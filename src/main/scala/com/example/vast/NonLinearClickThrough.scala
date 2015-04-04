package com.example.vast

import java.net.URI

import scala.xml.Node

case class NonLinearClickThrough(value: URI)

object NonLinearClickThrough extends VASTElement[NonLinearClickThrough] {

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
  def fromXML(node: Node): NonLinearClickThrough =
    NonLinearClickThrough(URI.create(node.text))

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: NonLinearClickThrough): Node =
    <NonLinearClickThrough>{ t.value.asCData }</NonLinearClickThrough>

}
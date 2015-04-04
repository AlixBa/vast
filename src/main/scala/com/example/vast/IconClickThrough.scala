package com.example.vast

import java.net.URI

import scala.xml.Node

case class IconClickThrough(value: URI)

object IconClickThrough extends VASTElement[IconClickThrough] {

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
  def fromXML(node: Node): IconClickThrough =
    IconClickThrough(URI.create(node.text))

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: IconClickThrough): Node =
    <IconClickThrough>{ t.value.asCData }</IconClickThrough>

}
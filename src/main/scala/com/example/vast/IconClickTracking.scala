package com.example.vast

import java.net.URI

import scala.xml.Node

case class IconClickTracking(value: URI)

object IconClickTracking extends VASTElement[IconClickTracking] {

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
  def fromXML(node: Node): IconClickTracking =
    IconClickTracking(URI.create(node.text))

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: IconClickTracking): Node =
    <IconClickTracking>{ t.value.asCData }</IconClickTracking>

}
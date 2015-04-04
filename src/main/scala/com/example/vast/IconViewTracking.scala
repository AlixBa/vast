package com.example.vast

import java.net.URI

import scala.xml.Node

case class IconViewTracking(value: URI)

object IconViewTracking extends VASTElement[IconViewTracking] {

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
  def fromXML(node: Node): IconViewTracking =
    IconViewTracking(URI.create(node.text))

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: IconViewTracking): Node =
    <IconViewTracking>{ t.value.asCData }</IconViewTracking>

}
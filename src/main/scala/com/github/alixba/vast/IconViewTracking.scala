package com.github.alixba.vast

import scala.xml.Node

case class IconViewTracking(value: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <IconViewTracking>{ value.asCData }</IconViewTracking>

}

object IconViewTracking extends VASTElementCompanion[IconViewTracking] {

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
    IconViewTracking(node.text)

}
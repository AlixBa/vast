package com.github.alixba.vast

import scala.xml.Node

case class Advertiser(value: String) extends VASTElement {
  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Advertiser>{ value }</Advertiser>

}

object Advertiser extends VASTElementCompanion[Advertiser] {

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
  def fromXML(node: Node): Advertiser =
    Advertiser(node.text)

}
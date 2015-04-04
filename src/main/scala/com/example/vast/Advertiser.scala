package com.example.vast

import scala.xml.Node

case class Advertiser(value: String)

object Advertiser extends VASTElement[Advertiser] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Advertiser): Node =
    <Advertiser>{ t.value }</Advertiser>

}
package com.github.alixba.vast

import java.net.URI

import scala.xml.Node

case class Impression(value: URI, id: Option[String]) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Impression id={ id }>{ value.asCData }</Impression>

}

object Impression extends VASTElementCompanion[Impression] {

  def apply(value: URI): Impression =
    Impression(value, None)

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
  def fromXML(node: Node): Impression = {
    val value = URI.create(node.text)
    val id = (node \ "@id").headOption

    Impression(value, id)
  }

}
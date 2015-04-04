package com.example.vast

import java.net.URI

import scala.xml.Node

case class ClickThrough(value: URI, id: Option[String])

object ClickThrough extends VASTElement[ClickThrough] {

  def apply(value: URI): ClickThrough =
    ClickThrough(value, None)

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
  def fromXML(node: Node): ClickThrough = {
    val value = URI.create(node.text)
    val id = (node \ "@id").headOption

    ClickThrough(value, id)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: ClickThrough): Node =
    <ClickThrough id={ t.id }>{ t.value.asCData }</ClickThrough>

}
package com.example.vast

import java.net.URI

import scala.xml.Node

case class ClickTracking(value: URI, id: Option[String])

object ClickTracking extends VASTElement[ClickTracking] {

  def apply(value: URI): ClickTracking =
    ClickTracking(value, None)

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
  def fromXML(node: Node): ClickTracking = {
    val value = URI.create(node.text)
    val id = (node \ "@id").headOption

    ClickTracking(value, id)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: ClickTracking): Node =
    <ClickTracking id={ t.id }>{ t.value.asCData }</ClickTracking>

}
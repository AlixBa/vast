package com.github.alixba.vast

import scala.xml.Node

case class Tracking(value: String, event: Event, offset: Option[String]) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Tracking event={ event.toString } offset={ offset }>{ value.asCData }</Tracking>

}

object Tracking extends VASTElementCompanion[Tracking] {

  def apply(value: String, event: Event): Tracking =
    Tracking(value, event, None)

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
  def fromXML(node: Node): Tracking = {
    val value = node.text
    val event = (node \ "@event").headOption.map(n ⇒ Event.fromString(n.text)).getOrElseMissingException("event")
    val offset = (node \ "@offset").headOption

    Tracking(value, event, offset)
  }

}
package alixba.vast

import java.net.URI

import scala.xml.Node

case class Tracking(value: URI, event: Event, offset: Option[String]) extends VASTElement[Tracking] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <Tracking event={ event.toString } offset={ offset }>{ value.asCData }</Tracking>

}

object Tracking extends VASTElementCompanion[Tracking] {

  def apply(value: URI, event: Event): Tracking =
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
    val value = URI.create(node.text)
    val event = (node \ "@event").headOption.map(n ⇒ Event.fromString(n.text)).getOrElseMissingException("event")
    val offset = (node \ "@offset").headOption

    Tracking(value, event, offset)
  }

}
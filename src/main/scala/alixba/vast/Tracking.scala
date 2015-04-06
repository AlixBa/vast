package alixba.vast

import java.net.URI

import scala.xml.Node

case class Tracking(value: URI, event: Event, offset: Option[String])

object Tracking extends VASTElement[Tracking] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Tracking): Node =
    <Tracking event={ t.event.toString } offset={ t.offset }>{ t.value.asCData }</Tracking>

}
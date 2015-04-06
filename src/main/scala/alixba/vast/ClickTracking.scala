package alixba.vast

import java.net.URI

import scala.xml.Node

case class ClickTracking(value: URI, id: Option[String]) extends VASTElement[ClickTracking] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <ClickTracking id={ id }>{ value.asCData }</ClickTracking>

}

object ClickTracking extends VASTElementCompanion[ClickTracking] {

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

}
package alixba.vast

import java.net.URI

import scala.xml.Node

case class Impression(value: URI, id: Option[String])

object Impression extends VASTElement[Impression] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Impression): Node =
    <Impression id={ t.id }>{ t.value.asCData }</Impression>

}
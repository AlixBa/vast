package alixba.vast

import java.net.URI

import scala.xml.Node

case class ClickThrough(value: URI, id: Option[String]) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <ClickThrough id={ id }>{ value.asCData }</ClickThrough>

}

object ClickThrough extends VASTElementCompanion[ClickThrough] {

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

}
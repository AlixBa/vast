package alixba.vast

import java.net.URI

import scala.xml.Node

case class CustomClick(value: URI, id: Option[String]) extends VASTElement[CustomClick] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <CustomClick id={ id }>{ value.asCData }</CustomClick>

}

object CustomClick extends VASTElementCompanion[CustomClick] {

  def apply(value: URI): CustomClick =
    CustomClick(value, None)

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
  def fromXML(node: Node): CustomClick = {
    val value = URI.create(node.text)
    val id = (node \ "@id").headOption

    CustomClick(value, id)
  }

}
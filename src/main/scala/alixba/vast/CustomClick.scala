package alixba.vast

import java.net.URI

import scala.xml.Node

case class CustomClick(value: URI, id: Option[String])

object CustomClick extends VASTElement[CustomClick] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: CustomClick): Node =
    <CustomClick id={ t.id }>{ t.value.asCData }</CustomClick>

}
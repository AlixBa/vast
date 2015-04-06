package alixba.vast

import java.net.URI

import scala.xml.Node

case class StaticResource(value: URI, creativeType: String) extends IconElement with InLineCompanionElement
  with InLineNonLinearElement with WrapperCompanionElement

object StaticResource extends VASTElement[StaticResource] {

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
  def fromXML(node: Node): StaticResource = {
    val value = URI.create(node.text)
    val creativeType = (node \ "@creativeType").headOption.getOrElseMissingException("creativeType")

    StaticResource(value, creativeType)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: StaticResource): Node =
    <StaticResource creativeType={ t.creativeType }>{ t.value.asCData }</StaticResource>

}
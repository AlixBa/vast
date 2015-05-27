package com.github.alixba.vast

import scala.xml.Node

case class StaticResource(value: String, creativeType: String) extends Resource {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <StaticResource creativeType={ creativeType }>{ value.asCData }</StaticResource>

}

object StaticResource extends VASTElementCompanion[StaticResource] {

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
    val value = node.text
    val creativeType = (node \ "@creativeType").headOption.getOrElseMissingException("creativeType")

    StaticResource(value, creativeType)
  }

}
package alixba.vast

import java.net.URI

import scala.xml.Node

case class CompanionClickThrough(value: URI) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <CompanionClickThrough>{ value.asCData }</CompanionClickThrough>

}

object CompanionClickThrough extends VASTElementCompanion[CompanionClickThrough] {

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
  def fromXML(node: Node): CompanionClickThrough =
    CompanionClickThrough(URI.create(node.text))

}

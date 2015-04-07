package alixba.vast

import java.net.URI

import scala.xml.Node

case class CompanionClickTracking(value: URI) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <CompanionClickTracking>{ value.asCData }</CompanionClickTracking>

}

object CompanionClickTracking extends VASTElementCompanion[CompanionClickTracking] {

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
  def fromXML(node: Node): CompanionClickTracking =
    CompanionClickTracking(URI.create(node.text))

}


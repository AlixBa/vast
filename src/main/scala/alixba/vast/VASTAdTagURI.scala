package alixba.vast

import java.net.URI

import scala.xml.Node

case class VASTAdTagURI(value: URI) extends VASTElement[VASTAdTagURI] {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node =
    <VASTAdTagURI>{ value.asCData }</VASTAdTagURI>

}

object VASTAdTagURI extends VASTElementCompanion[VASTAdTagURI] {

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
  def fromXML(node: Node): VASTAdTagURI =
    VASTAdTagURI(URI.create(node.text))

}
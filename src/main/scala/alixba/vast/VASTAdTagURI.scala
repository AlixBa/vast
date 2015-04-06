package alixba.vast

import java.net.URI

import scala.xml.Node

case class VASTAdTagURI(value: URI)

object VASTAdTagURI extends VASTElement[VASTAdTagURI] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: VASTAdTagURI): Node =
    <VASTAdTagURI>{ t.value.asCData }</VASTAdTagURI>

}
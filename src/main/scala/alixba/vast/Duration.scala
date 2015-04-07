package alixba.vast

import javax.xml.datatype.XMLGregorianCalendar

import scala.xml.Node

case class Duration(value: XMLGregorianCalendar) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Duration>{ value }</Duration>

}

object Duration extends VASTElementCompanion[Duration] {

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
  def fromXML(node: Node): Duration =
    Duration(node)

}

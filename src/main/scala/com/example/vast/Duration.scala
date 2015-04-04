package com.example.vast

import javax.xml.datatype.{ DatatypeFactory, XMLGregorianCalendar }

import scala.xml.Node

case class Duration(value: XMLGregorianCalendar)

object Duration extends VASTElement[Duration] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Duration): Node =
    <Duration>{ t.value }</Duration>

}

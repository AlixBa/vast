package com.github.alixba.vast

import javax.xml.datatype.XMLGregorianCalendar

import scala.language.implicitConversions
import scala.xml._

trait VASTElement extends toXMLImplicits {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node

  /**
   * Use this method to prevent Text nodes to be escaped
   * while transformed to string. Used because XML.fromString
   * does not keep the CData format.
   */
  protected def preventEscaping(nodes: Seq[Node]): Seq[Node] = {
    nodes.map({
      case e @ Elem(p, l, a, s, _*)          ⇒ Elem(p, l, a, s, true, preventEscaping(e.child): _*)
      case Group(n)                          ⇒ Group(preventEscaping(n))
      case Text(str) if shouldBeEncoded(str) ⇒ PCData(str)
      case n                                 ⇒ n
    })
  }

  protected def shouldBeEncoded(str: String): Boolean = {
    str.contains("<") ||
      str.contains(">") ||
      str.contains("&") ||
      str.contains("\"")
  }

}

trait toXMLImplicits {

  implicit def intOptToTextOpt(opt: Option[Int]): Option[Text] =
    opt.map(v ⇒ Text(v.toString))

  implicit def stringOptToTextOpt(opt: Option[String]): Option[Text] =
    opt.map(v ⇒ Text(v))

  implicit def booleanOptToTextOpt(opt: Option[Boolean]): Option[Text] =
    opt.map(v ⇒ Text(v.toString))

  implicit def calendarOptToTextOpt(opt: Option[XMLGregorianCalendar]): Option[Text] =
    opt.map(v ⇒ Text(v.toXMLFormat))

  implicit def intToText(v: Int): Text =
    Text(v.toString)

  implicit def stringToText(v: String): Text =
    Text(v)

  implicit def booleanToText(v: Boolean): Text =
    Text(v.toString)

  implicit def calendarToText(v: XMLGregorianCalendar): Text =
    Text(v.toXMLFormat)

}
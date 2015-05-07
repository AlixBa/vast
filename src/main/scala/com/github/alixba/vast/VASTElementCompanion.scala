package com.github.alixba.vast

import javax.xml.datatype.{ DatatypeFactory, XMLGregorianCalendar }
import javax.xml.parsers.SAXParserFactory

import scala.language.implicitConversions
import scala.xml._

object VASTElementCompanion {

  lazy val saxParserFactory = SAXParserFactory.newInstance()
  saxParserFactory.setNamespaceAware(false)

  lazy val datatypeFactory = DatatypeFactory.newInstance()

}

trait VASTElementCompanion[T] extends fromXMLImplicits {

  /**
   * Deserializes a String to a T.
   * Makes use of the fromXML method.
   * Why fromXML? because it is way simpler
   * to transform Node -> T than String -> T.
   */
  def fromString(string: String): T = {
    // don't recreate Factory every time
    val saxParser = VASTElementCompanion.saxParserFactory.newSAXParser()

    fromXML(XML.withSAXParser(saxParser).loadString(string))
  }

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
  def fromXML(node: Node): T

}

trait fromXMLImplicits {

  implicit def nodeOptToIntOpt(opt: Option[Node]): Option[Int] =
    opt.map(_.text.toInt)

  implicit def nodeOptToStringOpt(opt: Option[Node]): Option[String] =
    opt.map(_.text)

  implicit def nodeOptToBooleanOpt(opt: Option[Node]): Option[Boolean] =
    opt.map(_.text.equalsIgnoreCase("true"))

  implicit def nodeOptToCalendarOpt(opt: Option[Node]): Option[XMLGregorianCalendar] =
    opt.map(n ⇒ VASTElementCompanion.datatypeFactory.newXMLGregorianCalendar(n.text))

  implicit def nodeToInt(n: Node): Int =
    n.text.toInt

  implicit def nodeToString(n: Node): String =
    n.text

  implicit def nodeToCalendar(n: Node): XMLGregorianCalendar =
    VASTElementCompanion.datatypeFactory.newXMLGregorianCalendar(n.text)

}
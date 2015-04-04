package com.example

import java.net.URI
import javax.xml.datatype.{ DatatypeFactory, XMLGregorianCalendar }

import scala.language.implicitConversions
import scala.xml._

package object vast {

  val factory = DatatypeFactory.newInstance()

  trait VASTElement[T] extends fromXMLImplicits with toXMLImplicits {

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

    /**
     * Deserializes a String to a T.
     * Makes use of the fromXML method.
     * Why fromXML? because it is way simplier
     * to transform Node -> T than String -> T.
     */
    def fromString(string: String): T =
      fromXML(XML.loadString(string))

    /**
     * Serializes a T to a Node.
     */
    def toXML(t: T): Node

    def toString(t: T): String =
      toXML(t).toString()

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

  trait fromXMLImplicits {

    implicit def nodeOptToIntOpt(opt: Option[Node]): Option[Int] =
      opt.map(_.text.toInt)

    implicit def nodeOptToStringOpt(opt: Option[Node]): Option[String] =
      opt.map(_.text)

    implicit def nodeOptToBooleanOpt(opt: Option[Node]): Option[Boolean] =
      opt.map(_.text.equalsIgnoreCase("true"))

    implicit def nodeOptToCalendarOpt(opt: Option[Node]): Option[XMLGregorianCalendar] =
      opt.map(n ⇒ factory.newXMLGregorianCalendar(n.text))

    implicit def nodeToInt(n: Node): Int =
      n.text.toInt

    implicit def nodeToString(n: Node): String =
      n.text

    implicit def nodeToCalendar(n: Node): XMLGregorianCalendar =
      factory.newXMLGregorianCalendar(n.text)

  }

  /**
   * MissingElementException can be thrown when a mandatory
   * element is missing in the XML.
   */
  case class MissingElementException(elems: String*)
    extends RuntimeException(elems.mkString(" or "))

  implicit class RichOption[A](opt: Option[A]) {

    def getOrElseMissingException[B >: A](missing: String*): B = {
      if (opt.isEmpty) throw new MissingElementException(missing: _*)
      else opt.get
    }

  }

  implicit class RichMap(map: Map[String, String]) {

    def asMetaData: MetaData =
      map.foldLeft[MetaData](Null)((acc, mapEntry) ⇒ Attribute(mapEntry._1, Text(mapEntry._2), acc))
  }

  implicit class RichURI(uri: URI) {

    def asCData: PCData =
      PCData(uri.toString)

  }

}

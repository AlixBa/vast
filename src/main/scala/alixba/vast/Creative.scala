package alixba.vast

import scala.xml.Node

trait Creative[T] extends VASTElement[T] {

  def element: CreativeElement

  def id: Option[String]

  def sequence: Option[Int]

  def AdID: Option[String]

}

trait CreativeElement {
  self: VASTElement[_] ⇒

  def toXML: Node

}

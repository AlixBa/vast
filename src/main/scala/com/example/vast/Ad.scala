package com.example.vast

import scala.xml.Node

case class Ad(element: AdElement, id: Option[String], sequence: Option[Int])

object Ad extends VASTElement[Ad] {

  def apply(element: AdElement): Ad =
    Ad(element, None, None)

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
  def fromXML(node: Node): Ad = {
    val element = AdElement.fromXML(node)
    val id = (node \ "@id").headOption
    val sequence = (node \ "@sequence").headOption

    Ad(element, id, sequence)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Ad): Node = {
    val adElementXML = AdElement.toXML(t.element)

    <Ad id={ t.id } sequence={ t.sequence }>{ adElementXML }</Ad>
  }

}

trait AdElement

object AdElement extends VASTElement[AdElement] {

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
  def fromXML(node: Node): AdElement = {
    val inLine = (node \ "InLine").headOption.map(InLine.fromXML)
    val wrapper = (node \ "Wrapper").headOption.map(Wrapper.fromXML)

    inLine.getOrElse(wrapper.getOrElseMissingException("InLine", "Wrapper"))
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: AdElement): Node = {
    t match {
      case i @ InLine(_, _, _, _, _, _, _, _, _, _) ⇒ InLine.toXML(i)
      case w @ Wrapper(_, _, _, _, _, _)            ⇒ Wrapper.toXML(w)
    }
  }

}
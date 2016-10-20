package com.github.alixba.vast

import scala.xml.Node

case class Ad(element: AdElement, id: Option[String], sequence: Option[Int]) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Ad id={ id } sequence={ sequence }>{ element.toXML }</Ad>

}

object Ad extends VASTElementCompanion[Ad] {

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

}

trait AdElement extends VASTElement {

  def adSystem: AdSystem

  def error: Option[Error]

  def impressions: Seq[Impression]

  def creatives: Seq[Creative]

  def extensions: Option[Seq[Extension]]

  def viewableImpression: Option[ViewableImpression]

}

object AdElement extends VASTElementCompanion[AdElement] {

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

}
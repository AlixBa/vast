package com.example.vast

import javax.xml.datatype.{ DatatypeFactory, XMLGregorianCalendar }

import scala.xml.Node

case class InLineNonLinear(element: InLineNonLinearElement, width: Int, height: Int,
                           creativeExtensions:      Option[Seq[CreativeExtension]],
                           nonLinearClicksTracking: Seq[NonLinearClickTracking],
                           nonLinearClickThrough:   Option[NonLinearClickThrough],
                           adParameters:            Option[AdParameters], id: Option[String], expandedWidth: Option[Int],
                           expandedHeight: Option[Int], scalable: Option[Boolean], maintainAspectRatio: Option[Boolean],
                           minSuggestedDuration: Option[XMLGregorianCalendar], apiFramework: Option[String])

object InLineNonLinear extends VASTElement[InLineNonLinear] {

  def apply(element: InLineNonLinearElement, width: Int, height: Int): InLineNonLinear =
    InLineNonLinear(element, width, height, None, Seq.empty, None, None, None, None, None, None, None, None, None)

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
  def fromXML(node: Node): InLineNonLinear = {
    val element = InLineNonLinearElement.fromXML(node)
    val width = (node \ "@width").headOption.getOrElseMissingException("width")
    val height = (node \ "@height").headOption.getOrElseMissingException("height")
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").toSeq.map(CreativeExtension.fromXML))
    val nonLinearClicksTracking = (node \ "NonLinearClickTracking").toSeq.map(NonLinearClickTracking.fromXML)
    val nonLinearClickThrough = (node \ "NonLinearClickThrough").headOption.map(NonLinearClickThrough.fromXML)
    val adParameters = (node \ "AdParameters").headOption.map(AdParameters.fromXML)
    val id = (node \ "@id").headOption
    val expandedWidth = (node \ "@expandedWidth").headOption
    val expandedHeight = (node \ "@expandedHeight").headOption
    val scalable = (node \ "@scalable").headOption
    val maintainAspectRatio = (node \ "@maintainAspectRatio").headOption
    val minSuggestedDuration = (node \ "@minSuggestedDuration").headOption
    val apiFramework = (node \ "@apiFramework").headOption

    InLineNonLinear(element, width, height, creativeExtensions, nonLinearClicksTracking, nonLinearClickThrough,
      adParameters, id, expandedWidth, expandedHeight, scalable, maintainAspectRatio, minSuggestedDuration, apiFramework)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineNonLinear): Node = {
    val elementXML = InLineNonLinearElement.toXML(t.element)
    val creativeExtensionsXML = t.creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(CreativeExtension.toXML) }</CreativeExtensions>).toSeq
    val nonLinearClicksTrackingXML = t.nonLinearClicksTracking.map(NonLinearClickTracking.toXML)
    val nonLinearClickThroughXML = t.nonLinearClickThrough.map(NonLinearClickThrough.toXML).toSeq
    val adParametersXML = t.adParameters.map(AdParameters.toXML).toSeq

    <NonLinear width={ t.width } height={ t.height } id={ t.id } expandedWidth={ t.expandedWidth } expandedHeight={ t.expandedHeight } scalable={ t.scalable } maintainAspectRatio={ t.maintainAspectRatio } minSuggestedDuration={ t.minSuggestedDuration } apiFramework={ t.apiFramework }>{ elementXML }{ creativeExtensionsXML }{ nonLinearClicksTrackingXML }{ nonLinearClickThroughXML }{ adParametersXML }</NonLinear>
  }

}

trait InLineNonLinearElement

object InLineNonLinearElement extends VASTElement[InLineNonLinearElement] {

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
  def fromXML(node: Node): InLineNonLinearElement = {
    val html = (node \ "HTMLResource").headOption.map(HTMLResource.fromXML)
    val iframe = (node \ "IFrameResource").headOption.map(IFrameResource.fromXML)
    val static = (node \ "StaticResource").headOption.map(StaticResource.fromXML)

    html.getOrElse(
      iframe.getOrElse(
        static.getOrElseMissingException("HTMLResource", "IFrameResource", "StaticResource")
      )
    )
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineNonLinearElement): Node = {
    t match {
      case h @ HTMLResource(_, _)   ⇒ HTMLResource.toXML(h)
      case i @ IFrameResource(_)    ⇒ IFrameResource.toXML(i)
      case s @ StaticResource(_, _) ⇒ StaticResource.toXML(s)
    }
  }

}
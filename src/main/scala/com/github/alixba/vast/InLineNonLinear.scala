package com.github.alixba.vast

import javax.xml.datatype.XMLGregorianCalendar

import scala.xml.Node

case class InLineNonLinear(element: Resource, creativeExtensions: Option[Seq[CreativeExtension]],
                           nonLinearClicksTracking: Seq[NonLinearClickTracking],
                           nonLinearClickThrough:   Option[NonLinearClickThrough], adParameters: Option[AdParameters],
                           id: Option[String], width: Int, height: Int, expandedWidth: Option[Int],
                           expandedHeight: Option[Int], scalable: Option[Boolean], maintainAspectRatio: Option[Boolean],
                           minSuggestedDuration: Option[XMLGregorianCalendar], apiFramework: Option[String])
    extends NonLinear {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val elementXML = element.toXML
    val creativeExtensionsXML = creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(_.toXML) }</CreativeExtensions>).toSeq
    val nonLinearClicksTrackingXML = nonLinearClicksTracking.map(_.toXML)
    val nonLinearClickThroughXML = nonLinearClickThrough.map(_.toXML).toSeq
    val adParametersXML = adParameters.map(_.toXML).toSeq

    <NonLinear id={ id } width={ width } height={ height } expandedWidth={ expandedWidth } expandedHeight={ expandedHeight } scalable={ scalable } maintainAspectRatio={ maintainAspectRatio } minSuggestedDuration={ minSuggestedDuration } apiFramework={ apiFramework }>{ elementXML }{ creativeExtensionsXML }{ nonLinearClicksTrackingXML }{ nonLinearClickThroughXML }{ adParametersXML }</NonLinear>
  }

}

object InLineNonLinear extends VASTElementCompanion[InLineNonLinear] {

  def apply(element: Resource, width: Int, height: Int): InLineNonLinear =
    InLineNonLinear(element, None, Seq.empty, None, None, None, width, height, None, None, None, None, None, None)

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
    val element = Resource.fromXML(node)
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").map(CreativeExtension.fromXML))
    val nonLinearClicksTracking = (node \ "NonLinearClickTracking").map(NonLinearClickTracking.fromXML)
    val nonLinearClickThrough = (node \ "NonLinearClickThrough").headOption.map(NonLinearClickThrough.fromXML)
    val adParameters = (node \ "AdParameters").headOption.map(AdParameters.fromXML)
    val id = (node \ "@id").headOption
    val width = (node \ "@width").headOption.getOrElseMissingException("width")
    val height = (node \ "@height").headOption.getOrElseMissingException("height")
    val expandedWidth = (node \ "@expandedWidth").headOption
    val expandedHeight = (node \ "@expandedHeight").headOption
    val scalable = (node \ "@scalable").headOption
    val maintainAspectRatio = (node \ "@maintainAspectRatio").headOption
    val minSuggestedDuration = (node \ "@minSuggestedDuration").headOption
    val apiFramework = (node \ "@apiFramework").headOption

    InLineNonLinear(element, creativeExtensions, nonLinearClicksTracking, nonLinearClickThrough, adParameters, id,
      width, height, expandedWidth, expandedHeight, scalable, maintainAspectRatio, minSuggestedDuration, apiFramework)
  }

}
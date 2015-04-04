package com.example.vast

import scala.xml.Node

case class WrapperCompanion(width: Int, height: Int, element: WrapperCompanionElement,
                            creativeExtensions: Option[Seq[CreativeExtension]], trackingEvents: Option[Seq[Tracking]],
                            companionClickThrough:  Option[CompanionClickThrough],
                            companionClickTracking: Seq[CompanionClickTracking], altText: Option[AltText],
                            adParameters: Option[AdParameters], id: Option[String], assetWidth: Option[Int],
                            assetHeight: Option[Int], expandedWidth: Option[Int], expandedHeight: Option[Int],
                            apiFramework: Option[String], adSlotId: Option[String])

object WrapperCompanion extends VASTElement[WrapperCompanion] {

  def apply(width: Int, height: Int, element: WrapperCompanionElement): WrapperCompanion =
    WrapperCompanion(width, height, element, None, None, None, Seq.empty, None, None, None, None, None, None, None, None, None)

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
  def fromXML(node: Node): WrapperCompanion = {
    val width = (node \ "@width").headOption.getOrElseMissingException("width")
    val height = (node \ "@height").headOption.getOrElseMissingException("height")
    val element = WrapperCompanionElement.fromXML(node)
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").toSeq.map(CreativeExtension.fromXML))
    val trackingEvents = (node \ "TrackingEvents")
      .headOption.map(n ⇒ (n \ "Tracking").toSeq.map(Tracking.fromXML))
    val companionClickThrough = (node \ "CompanionClickThrough").headOption.map(CompanionClickThrough.fromXML)
    val companionClickTracking = (node \ "CompanionClickTracking").toSeq.map(CompanionClickTracking.fromXML)
    val altText = (node \ "AltText").headOption.map(AltText.fromXML)
    val adParameters = (node \ "AdParameters").headOption.map(AdParameters.fromXML)
    val id = (node \ "@id").headOption
    val assetWidth = (node \ "@assetWidth").headOption
    val assetHeight = (node \ "@assetHeight").headOption
    val expandedWidth = (node \ "@expandedWidth").headOption
    val expandedHeight = (node \ "@expandedHeight").headOption
    val apiFramework = (node \ "@apiFramework").headOption
    val adSlotId = (node \ "@adSlotId").headOption

    WrapperCompanion(width, height, element, creativeExtensions, trackingEvents, companionClickThrough,
      companionClickTracking, altText, adParameters, id, assetWidth, assetHeight, expandedWidth, expandedHeight,
      apiFramework, adSlotId)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: WrapperCompanion): Node = {
    val elementXML = WrapperCompanionElement.toXML(t.element)
    val creativeExtensionsXML = t.creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(CreativeExtension.toXML) }</CreativeExtensions>).toSeq
    val trackingEventsXML = t.trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(Tracking.toXML) }</TrackingEvents>).toSeq
    val companionClickThroughXML = t.companionClickThrough.map(CompanionClickThrough.toXML).toSeq
    val companionClickTrackingXML = t.companionClickTracking.map(CompanionClickTracking.toXML)
    val altTextXML = t.altText.map(AltText.toXML).toSeq
    val adParametersXML = t.adParameters.map(AdParameters.toXML).toSeq

    <Companion width={ t.width } height={ t.height } id={ t.id } assetWidth={ t.assetWidth } assetHeight={ t.assetHeight } expandedWidth={ t.expandedWidth } expandedHeight={ t.expandedHeight } apiFramework={ t.apiFramework } adSlotId={ t.adSlotId }>{ elementXML }{ creativeExtensionsXML }{ trackingEventsXML }{ companionClickThroughXML }{ companionClickTrackingXML }{ altTextXML }{ adParametersXML }</Companion>
  }

}

trait WrapperCompanionElement

object WrapperCompanionElement extends VASTElement[WrapperCompanionElement] {

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
  def fromXML(node: Node): WrapperCompanionElement = {
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
  def toXML(t: WrapperCompanionElement): Node = {
    t match {
      case h @ HTMLResource(_, _)   ⇒ HTMLResource.toXML(h)
      case i @ IFrameResource(_)    ⇒ IFrameResource.toXML(i)
      case s @ StaticResource(_, _) ⇒ StaticResource.toXML(s)
    }
  }

}
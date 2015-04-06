package alixba.vast

import scala.xml.Node

case class InLineCompanion(width: Int, height: Int, element: InLineCompanionElement,
                           creativeExtensions: Option[Seq[CreativeExtension]], trackingEvents: Option[Seq[Tracking]],
                           companionClickThrough: Option[CompanionClickThrough], altText: Option[AltText],
                           adParameters: Option[AdParameters], id: Option[String], assetWidth: Option[Int],
                           assetHeight: Option[Int], expandedWidth: Option[Int], expandedHeight: Option[Int],
                           apiFramework: Option[String], adSlotId: Option[String])

object InLineCompanion extends VASTElement[InLineCompanion] {

  def apply(width: Int, height: Int, element: InLineCompanionElement): InLineCompanion =
    InLineCompanion(width, height, element, None, None, None, None, None, None, None, None, None, None, None, None)

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
  def fromXML(node: Node): InLineCompanion = {
    val width = (node \ "@width").headOption.getOrElseMissingException("width")
    val height = (node \ "@height").headOption.getOrElseMissingException("height")
    val element = InLineCompanionElement.fromXML(node)
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").toSeq.map(CreativeExtension.fromXML))
    val trackingEvents = (node \ "TrackingEvents")
      .headOption.map(n ⇒ (n \ "Tracking").toSeq.map(Tracking.fromXML))
    val companionClickThrough = (node \ "CompanionClickThrough").headOption.map(CompanionClickThrough.fromXML)
    val altText = (node \ "AltText").headOption.map(AltText.fromXML)
    val adParameters = (node \ "AdParameters").headOption.map(AdParameters.fromXML)
    val id = (node \ "@id").headOption
    val assetWidth = (node \ "@assetWidth").headOption
    val assetHeight = (node \ "@assetHeight").headOption
    val expandedWidth = (node \ "@expandedWidth").headOption
    val expandedHeight = (node \ "@expandedHeight").headOption
    val apiFramework = (node \ "@apiFramework").headOption
    val adSlotId = (node \ "@adSlotId").headOption

    InLineCompanion(width, height, element, creativeExtensions, trackingEvents, companionClickThrough, altText,
      adParameters, id, assetWidth, assetHeight, expandedWidth, expandedHeight, apiFramework, adSlotId)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineCompanion): Node = {
    val elementXML = InLineCompanionElement.toXML(t.element)
    val creativeExtensionsXML = t.creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(CreativeExtension.toXML) }</CreativeExtensions>).toSeq
    val trackingEventsXML = t.trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(Tracking.toXML) }</TrackingEvents>).toSeq
    val companionClickThroughXML = t.companionClickThrough.map(CompanionClickThrough.toXML).toSeq
    val altTextXML = t.altText.map(AltText.toXML).toSeq
    val adParametersXML = t.adParameters.map(AdParameters.toXML).toSeq

    <Companion width={ t.width } height={ t.height } id={ t.id } assetWidth={ t.assetWidth } assetHeight={ t.assetHeight } expandedWidth={ t.expandedWidth } expandedHeight={ t.expandedHeight } apiFramework={ t.apiFramework } adSlotId={ t.adSlotId }>{ elementXML }{ creativeExtensionsXML }{ trackingEventsXML }{ companionClickThroughXML }{ altTextXML }{ adParametersXML }</Companion>
  }

}

trait InLineCompanionElement

object InLineCompanionElement extends VASTElement[InLineCompanionElement] {

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
  def fromXML(node: Node): InLineCompanionElement = {
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
  def toXML(t: InLineCompanionElement): Node = {
    t match {
      case h @ HTMLResource(_, _)   ⇒ HTMLResource.toXML(h)
      case i @ IFrameResource(_)    ⇒ IFrameResource.toXML(i)
      case s @ StaticResource(_, _) ⇒ StaticResource.toXML(s)
    }
  }

}
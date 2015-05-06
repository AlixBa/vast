package com.github.alixba.vast

import scala.xml.Node

case class InLine(adSystem: AdSystem, adTitle: AdTitle, description: Option[Description],
                  advertiser: Option[Advertiser], pricing: Option[Pricing], survey: Option[Survey],
                  error: Option[Error], impressions: Seq[Impression], creatives: Seq[InLineCreative],
                  extensions: Option[Seq[Extension]]) extends AdElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val adSystemXML = adSystem.toXML
    val adTitleXML = adTitle.toXML
    val descriptionXML = description.map(_.toXML).toSeq
    val advertiserXML = advertiser.map(_.toXML).toSeq
    val pricingXML = pricing.map(_.toXML).toSeq
    val surveyXML = survey.map(_.toXML).toSeq
    val errorXML = error.map(_.toXML).toSeq
    val impressionXML = impressions.map(_.toXML)
    val creativesXML = creatives.map(_.toXML)
    val extensionsXML = extensions.map(n ⇒ <Extensions>{ n.map(_.toXML) }</Extensions>).toSeq

    <InLine>{ adSystemXML }{ adTitleXML }{ descriptionXML }{ advertiserXML }{ pricingXML }{ surveyXML }{ errorXML }{ impressionXML }<Creatives>{ creativesXML }</Creatives>{ extensionsXML }</InLine>
  }

}

object InLine extends VASTElementCompanion[InLine] {

  def apply(adSystem: AdSystem, adTitle: AdTitle, creatives: Seq[InLineCreative]): InLine =
    InLine(adSystem, adTitle, None, None, None, None, None, Seq.empty, creatives, None)

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
  def fromXML(node: Node): InLine = {
    val adSystem = (node \ "AdSystem").headOption.map(AdSystem.fromXML).getOrElseMissingException("AdSystem")
    val adTitle = (node \ "AdTitle").headOption.map(AdTitle.fromXML).getOrElseMissingException("AdTitle")
    val description = (node \ "Description").headOption.map(Description.fromXML)
    val advertiser = (node \ "Advertiser").headOption.map(Advertiser.fromXML)
    val pricing = (node \ "Pricing").headOption.map(Pricing.fromXML)
    val survey = (node \ "Survey").headOption.map(Survey.fromXML)
    val error = (node \ "Error").headOption.map(Error.fromXML)
    val impressions = (node \ "Impression").map(Impression.fromXML)
    val creatives = (node \ "Creatives" \ "Creative").map(InLineCreative.fromXML)
    val extensions = (node \ "Extensions").headOption.map(n ⇒ (n \ "Extension").map(Extension.fromXML))

    InLine(adSystem, adTitle, description, advertiser, pricing, survey, error, impressions, creatives, extensions)
  }

}
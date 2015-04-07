package alixba.vast

import scala.xml.Node

case class InLine(adSystem: AdSystem, adTitle: AdTitle, creatives: Seq[InLineCreative],
                  description: Option[Description], advertiser: Option[Advertiser], pricing: Option[Pricing],
                  survey: Option[Survey], error: Option[Error], impressions: Seq[Impression],
                  extensions: Option[Seq[Extension]]) extends AdElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val adSystemXML = adSystem.toXML
    val adTitleXML = adTitle.toXML
    val creativesXML = creatives.map(_.toXML)
    val descriptionXML = description.map(_.toXML).toSeq
    val advertiserXML = advertiser.map(_.toXML).toSeq
    val pricingXML = pricing.map(_.toXML).toSeq
    val surveyXML = survey.map(_.toXML).toSeq
    val errorXML = error.map(_.toXML).toSeq
    val impressionXML = impressions.map(_.toXML)
    val extensionsXML = extensions.map(n ⇒ <Extensions>{ n.map(_.toXML) }</Extensions>).toSeq

    <InLine>{ adSystemXML }{ adTitleXML }{ descriptionXML }{ advertiserXML }{ pricingXML }{ surveyXML }{ errorXML }<Creatives>{ creativesXML }</Creatives>{ impressionXML }{ extensionsXML }</InLine>
  }

}

object InLine extends VASTElementCompanion[InLine] {

  def apply(adSystem: AdSystem, adTitle: AdTitle, creatives: Seq[InLineCreative]): InLine =
    InLine(adSystem, adTitle, creatives, None, None, None, None, None, Seq.empty, None)

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
    val creatives = (node \ "Creatives" \ "Creative").toSeq.map(InLineCreative.fromXML)
    val description = (node \ "Description").headOption.map(Description.fromXML)
    val advertiser = (node \ "Advertiser").headOption.map(Advertiser.fromXML)
    val pricing = (node \ "Pricing").headOption.map(Pricing.fromXML)
    val survey = (node \ "Survey").headOption.map(Survey.fromXML)
    val error = (node \ "Error").headOption.map(Error.fromXML)
    val impressions = (node \ "Impression").toSeq.map(Impression.fromXML)
    val extensions = (node \ "Extensions").headOption.map(n ⇒ (n \ "Extension").toSeq.map(Extension.fromXML))

    InLine(adSystem, adTitle, creatives, description, advertiser, pricing, survey, error, impressions, extensions)
  }

}
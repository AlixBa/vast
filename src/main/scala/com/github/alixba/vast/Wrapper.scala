package com.github.alixba.vast

import scala.xml.Node

case class Wrapper(adSystem: AdSystem, vastAdTagURI: VASTAdTagURI, error: Option[Error], impressions: Seq[Impression],
                   creatives: Seq[WrapperCreative], extensions: Option[Seq[Extension]],
                   viewableImpression: Option[ViewableImpression]) extends AdElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val adSystemXML = adSystem.toXML
    val vastAdTagURIXML = vastAdTagURI.toXML
    val errorXML = error.map(_.toXML).toSeq
    val impressionXML = impressions.map(_.toXML)
    val creativesXML = creatives.map(_.toXML)
    val extensionsXML = extensions.map(n ⇒ <Extensions>{ n.map(_.toXML) }</Extensions>).toSeq
    val viewableImpressionXML = viewableImpression.map(_.toXML).toSeq

    <Wrapper>{ adSystemXML }{ vastAdTagURIXML }{ errorXML }{ impressionXML }{ viewableImpressionXML }<Creatives>{ creativesXML }</Creatives>{ extensionsXML }</Wrapper>
  }

}

object Wrapper extends VASTElementCompanion[Wrapper] {

  def apply(adSystem: AdSystem, vastAdTagURI: VASTAdTagURI, creatives: Seq[WrapperCreative]): Wrapper =
    Wrapper(adSystem, vastAdTagURI, None, Seq.empty, creatives, None, None)

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
  def fromXML(node: Node): Wrapper = {
    val adSystem = (node \ "AdSystem").headOption.map(AdSystem.fromXML).getOrElseMissingException("AdSystem")
    val vastAdTagURI = (node \ "VASTAdTagURI")
      .headOption.map(VASTAdTagURI.fromXML).getOrElseMissingException("VASTAdTagURI")
    val error = (node \ "Error").headOption.map(Error.fromXML)
    val impressions = (node \ "Impression").map(Impression.fromXML)
    val creatives = (node \ "Creatives" \ "Creative").map(WrapperCreative.fromXML)
    val extensions = (node \ "Extensions").headOption.map(n ⇒ (n \ "Extension").map(Extension.fromXML))
    val viewableImpression = (node \ "ViewableImpression").headOption.map(ViewableImpression.fromXML)

    Wrapper(adSystem, vastAdTagURI, error, impressions, creatives, extensions, viewableImpression)
  }

}
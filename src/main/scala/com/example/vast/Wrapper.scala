package com.example.vast

import scala.xml.Node

case class Wrapper(adSystem: AdSystem, vastAdTagURI: VASTAdTagURI, creatives: Seq[WrapperCreative],
                   error: Option[Error], impressions: Seq[Impression], extensions: Option[Seq[Extension]])
    extends AdElement

object Wrapper extends VASTElement[Wrapper] {

  def apply(adSystem: AdSystem, vastAdTagURI: VASTAdTagURI, creatives: Seq[WrapperCreative]): Wrapper =
    Wrapper(adSystem, vastAdTagURI, creatives, None, Seq.empty, None)

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
    val creatives = (node \ "Creatives" \ "Creative").toSeq.map(WrapperCreative.fromXML)
    val error = (node \ "Error").headOption.map(Error.fromXML)
    val impressions = (node \ "Impression").toSeq.map(Impression.fromXML)
    val extensions = (node \ "Extensions").headOption.map(n ⇒ (n \ "Extension").toSeq.map(Extension.fromXML))

    Wrapper(adSystem, vastAdTagURI, creatives, error, impressions, extensions)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Wrapper): Node = {
    val adSystemXML = AdSystem.toXML(t.adSystem)
    val vastAdTagURIXML = VASTAdTagURI.toXML(t.vastAdTagURI)
    val creativesXML = t.creatives.map(WrapperCreative.toXML)
    val errorXML = t.error.map(Error.toXML).toSeq
    val impressionXML = t.impressions.map(Impression.toXML)
    val extensionsXML = t.extensions.map(n ⇒ <Extensions>{ n.map(Extension.toXML) }</Extensions>).toSeq

    <Wrapper>{ adSystemXML }{ vastAdTagURIXML }{ errorXML }<Creatives>{ creativesXML }</Creatives>{ impressionXML }{ extensionsXML }</Wrapper>
  }

}
package alixba.vast

import scala.xml.Node

case class Wrapper(adSystem: AdSystem, vastAdTagURI: VASTAdTagURI, creatives: Seq[WrapperCreative],
                   error: Option[Error], impressions: Seq[Impression], extensions: Option[Seq[Extension]])
    extends VASTElement[Wrapper] with AdElement {

  /**
   * Serializes this T to a Node.
   */
  def toXML: Node = {
    val adSystemXML = adSystem.toXML
    val vastAdTagURIXML = vastAdTagURI.toXML
    val creativesXML = creatives.map(_.toXML)
    val errorXML = error.map(_.toXML).toSeq
    val impressionXML = impressions.map(_.toXML)
    val extensionsXML = extensions.map(n ⇒ <Extensions>{ n.map(_.toXML) }</Extensions>).toSeq

    <Wrapper>{ adSystemXML }{ vastAdTagURIXML }{ errorXML }<Creatives>{ creativesXML }</Creatives>{ impressionXML }{ extensionsXML }</Wrapper>
  }

}

object Wrapper extends VASTElementCompanion[Wrapper] {

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

}
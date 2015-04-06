package alixba.vast

import scala.xml.Node

case class InLineLinear(duration: Duration, icons: Option[Seq[Icon]], creativeExtensions: Option[Seq[CreativeExtension]],
                        trackingEvents: Option[Seq[Tracking]], adParameters: Option[AdParameters],
                        videoClicks: Option[InLineVideoClicks], mediaFiles: Option[Seq[MediaFile]],
                        skipoffset: Option[String]) extends InLineCreativeElement

object InLineLinear extends VASTElement[InLineLinear] {

  def apply(duration: Duration): InLineLinear =
    InLineLinear(duration, None, None, None, None, None, None, None)

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
  def fromXML(node: Node): InLineLinear = {
    val duration = (node \ "Duration").headOption.map(Duration.fromXML).getOrElseMissingException("Duration")
    val icons = (node \ "Icons").headOption.map(n ⇒ (n \ "Icon").toSeq.map(Icon.fromXML))
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").toSeq.map(CreativeExtension.fromXML))
    val trackingEvents = (node \ "TrackingEvents")
      .headOption.map(n ⇒ (n \ "Tracking").toSeq.map(Tracking.fromXML))
    val adParameters = (node \ "AdParameters").headOption.map(AdParameters.fromXML)
    val videoClicks = (node \ "VideoClicks").headOption.map(InLineVideoClicks.fromXML)
    val mediaFiles = (node \ "MediaFiles")
      .headOption.map(n ⇒ (n \ "MediaFile").toSeq.map(MediaFile.fromXML))
    val skipoffset = (node \ "@skipoffset").headOption

    InLineLinear(duration, icons, creativeExtensions, trackingEvents, adParameters, videoClicks, mediaFiles, skipoffset)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: InLineLinear): Node = {
    val durationXML = Duration.toXML(t.duration)
    val iconsXML = t.icons.map(n ⇒ <Icons>{ n.map(Icon.toXML) }</Icons>).toSeq
    val creativeExtensionsXML = t.creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(CreativeExtension.toXML) }</CreativeExtensions>).toSeq
    val trackingEventsXML = t.trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(Tracking.toXML) }</TrackingEvents>).toSeq
    val adParametersXML = t.adParameters.map(AdParameters.toXML).toSeq
    val videoClicksXML = t.videoClicks.map(InLineVideoClicks.toXML).toSeq
    val mediaFilesXML = t.mediaFiles.map(n ⇒ <MediaFiles>{ n.map(MediaFile.toXML) }</MediaFiles>).toSeq

    <Linear skipoffset={ t.skipoffset }>{ durationXML }{ iconsXML }{ creativeExtensionsXML }{ trackingEventsXML }{ adParametersXML }{ videoClicksXML }{ mediaFilesXML }</Linear>
  }

}
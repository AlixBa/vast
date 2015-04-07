package alixba.vast

import scala.xml.Node

case class InLineLinear(duration: Duration, icons: Option[Seq[Icon]], creativeExtensions: Option[Seq[CreativeExtension]],
                        trackingEvents: Option[Seq[Tracking]], adParameters: Option[AdParameters],
                        videoClicks: Option[InLineVideoClicks], mediaFiles: Option[Seq[MediaFile]],
                        skipoffset: Option[String]) extends Linear with InLineCreativeElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val durationXML = duration.toXML
    val iconsXML = icons.map(n ⇒ <Icons>{ n.map(_.toXML) }</Icons>).toSeq
    val creativeExtensionsXML = creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(_.toXML) }</CreativeExtensions>).toSeq
    val trackingEventsXML = trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(_.toXML) }</TrackingEvents>).toSeq
    val adParametersXML = adParameters.map(_.toXML).toSeq
    val videoClicksXML = videoClicks.map(_.toXML).toSeq
    val mediaFilesXML = mediaFiles.map(n ⇒ <MediaFiles>{ n.map(_.toXML) }</MediaFiles>).toSeq

    <Linear skipoffset={ skipoffset }>{ durationXML }{ iconsXML }{ creativeExtensionsXML }{ trackingEventsXML }{ adParametersXML }{ videoClicksXML }{ mediaFilesXML }</Linear>
  }

}

object InLineLinear extends VASTElementCompanion[InLineLinear] {

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

}
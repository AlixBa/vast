package com.github.alixba.vast

import scala.xml.Node

case class InLineLinear(icons: Option[Seq[Icon]], creativeExtensions: Option[Seq[CreativeExtension]],
                        duration: Duration, trackingEvents: Option[Seq[Tracking]], adParameters: Option[AdParameters],
                        videoClicks: Option[InLineVideoClicks], mediaFiles: Option[Seq[MediaFile]],
                        skipoffset: Option[String]) extends Linear with InLineCreativeElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val iconsXML = icons.map(n ⇒ <Icons>{ n.map(_.toXML) }</Icons>).toSeq
    val creativeExtensionsXML = creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(_.toXML) }</CreativeExtensions>).toSeq
    val durationXML = duration.toXML
    val trackingEventsXML = trackingEvents.map(n ⇒ <TrackingEvents>{ n.map(_.toXML) }</TrackingEvents>).toSeq
    val adParametersXML = adParameters.map(_.toXML).toSeq
    val videoClicksXML = videoClicks.map(_.toXML).toSeq
    val mediaFilesXML = mediaFiles.map(n ⇒ <MediaFiles>{ n.map(_.toXML) }</MediaFiles>).toSeq

    <Linear skipoffset={ skipoffset }>{ iconsXML }{ creativeExtensionsXML }{ durationXML }{ trackingEventsXML }{ adParametersXML }{ videoClicksXML }{ mediaFilesXML }</Linear>
  }

}

object InLineLinear extends VASTElementCompanion[InLineLinear] {

  def apply(duration: Duration): InLineLinear =
    InLineLinear(None, None, duration, None, None, None, None, None)

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
    val icons = (node \ "Icons").headOption.map(n ⇒ (n \ "Icon").map(Icon.fromXML))
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").map(CreativeExtension.fromXML))
    val duration = (node \ "Duration").headOption.map(Duration.fromXML).getOrElseMissingException("Duration")
    val trackingEvents = (node \ "TrackingEvents").headOption.map(n ⇒ (n \ "Tracking").map(Tracking.fromXML))
    val adParameters = (node \ "AdParameters").headOption.map(AdParameters.fromXML)
    val videoClicks = (node \ "VideoClicks").headOption.map(InLineVideoClicks.fromXML)
    val mediaFiles = (node \ "MediaFiles").headOption.map(n ⇒ (n \ "MediaFile").map(MediaFile.fromXML))
    val skipoffset = (node \ "@skipoffset").headOption

    InLineLinear(icons, creativeExtensions, duration, trackingEvents, adParameters, videoClicks, mediaFiles, skipoffset)
  }

}
package com.example.vast

case class InLineLinear(duration: Duration, icons: Option[Seq[Icon]], creativeExtensions: Option[Seq[CreativeExtension]],
                        trackingEvents: Option[Seq[Tracking]], adParameters: Option[AdParameters],
                        videoClicks: Option[InLineVideoClicks], mediaFiles: Option[Seq[MediaFile]],
                        skipoffset: Option[String]) extends InLineCreativeElement

object InLineLinear {

  def apply(duration: Duration): InLineLinear =
    InLineLinear(duration, None, None, None, None, None, None, None)

}
package com.example.vast

case class WrapperLinear(creativeExtensions: Option[Seq[CreativeExtension]], icons: Option[Seq[Icon]],
                         trackingEvents: Option[Seq[Tracking]], videoClicks: Option[WrapperVideoClicks])
    extends WrapperCreativeElement
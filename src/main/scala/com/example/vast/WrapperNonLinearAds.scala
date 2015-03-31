package com.example.vast

case class WrapperNonLinearAds(trackingEvents: Option[Seq[Tracking]], nonLinear: Seq[WrapperNonLinear])
  extends WrapperCreativeElement
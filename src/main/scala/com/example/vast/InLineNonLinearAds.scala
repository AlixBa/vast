package com.example.vast

case class InLineNonLinearAds(trackingEvents: Option[Seq[Tracking]], nonLinears: Seq[InLineNonLinear])
  extends InLineCreativeElement
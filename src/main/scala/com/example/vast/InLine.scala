package com.example.vast

case class InLine(adSystem: AdSystem, adTitle: AdTitle, creatives: Seq[InLineCreative],
                  description: Option[Description], advertiser: Option[Advertiser], pricing: Option[Pricing],
                  survey: Option[Survey], error: Option[Error], impressions: Seq[Impression],
                  extensions: Option[Extensions]) extends AdElement

object InLine {

  def apply(adSystem: AdSystem, adTitle: AdTitle, creatives: Seq[InLineCreative]): InLine =
    InLine(adSystem, adTitle, creatives, None, None, None, None, None, Seq.empty, None)

}
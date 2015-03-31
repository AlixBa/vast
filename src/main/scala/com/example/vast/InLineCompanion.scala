package com.example.vast

trait InLineCompanionElement

case class InLineCompanion(width: Int, height: Int, element: InLineCompanionElement,
                           creativeExtensions: Option[Seq[CreativeExtension]], trackingEvents: Option[Seq[Tracking]],
                           companionClickThrough: Option[CompanionClickThrough], altText: Option[AltText],
                           adParameters: Option[AdParameters], id: Option[String], assetWidth: Option[Int],
                           assetHeight: Option[Int], expandedWidth: Option[Int], expandedHeight: Option[Int],
                           apiFramework: Option[String], adSlotId: Option[String])

object InLineCompanion {

  def apply(width: Int, height: Int, element: InLineCompanionElement): InLineCompanion =
    InLineCompanion(width, height, element, None, None, None, None, None, None, None, None, None, None, None, None)

}
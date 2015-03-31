package com.example.vast

trait WrapperCompanionElement

case class WrapperCompanion(width: Int, height: Int, element: WrapperCompanionElement,
                            creativeExtensions: Option[Seq[CreativeExtension]], trackingEvents: Option[Seq[Tracking]],
                            companionClickThrough: Option[java.net.URI], companionClickTracking: Seq[java.net.URI],
                            altText: Option[String], adParameters: Option[AdParameters], id: Option[String],
                            assetWidth: Option[Int], assetHeight: Option[Int], expandedWidth: Option[Int],
                            expandedHeight: Option[Int], apiFramework: Option[String], adSlotId: Option[String])

object WrapperCompanion {

  def apply(width: Int, height: Int, element: WrapperCompanionElement): WrapperCompanion =
    WrapperCompanion(width, height, element, None, None, None, Seq.empty, None, None, None, None, None, None, None, None, None)

}
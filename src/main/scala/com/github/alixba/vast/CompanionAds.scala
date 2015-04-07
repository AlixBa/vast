package com.github.alixba.vast

trait CompanionAds extends VASTElement {

  def companions: Seq[Companion]

}

trait Companion extends VASTElement {

  def width: Int

  def height: Int

  def element: Resource

  def creativeExtensions: Option[Seq[CreativeExtension]]

  def trackingEvents: Option[Seq[Tracking]]

  def companionClickThrough: Option[CompanionClickThrough]

  def altText: Option[AltText]

  def adParameters: Option[AdParameters]

  def id: Option[String]

  def assetWidth: Option[Int]

  def assetHeight: Option[Int]

  def expandedWidth: Option[Int]

  def expandedHeight: Option[Int]

  def apiFramework: Option[String]

  def adSlotId: Option[String]

}

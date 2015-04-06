package alixba.vast

trait CompanionAds[T] extends VASTElement[T] {

  def companions: Seq[Companion[_]]

}

trait Companion[T] extends VASTElement[T] {

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

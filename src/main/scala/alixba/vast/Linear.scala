package alixba.vast

trait Linear[T] extends VASTElement[T] {

  def creativeExtensions: Option[Seq[CreativeExtension]]

  def icons: Option[Seq[Icon]]

  def trackingEvents: Option[Seq[Tracking]]

  def videoClicks: Option[VideoClicks[_]]

}

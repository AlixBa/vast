package alixba.vast

trait VideoClicks[T] extends VASTElement[T] {

  def clicksTracking: Seq[ClickTracking]

  def customClicks: Seq[CustomClick]

}
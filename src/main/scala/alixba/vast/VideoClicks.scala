package alixba.vast

trait VideoClicks extends VASTElement {

  def clicksTracking: Seq[ClickTracking]

  def customClicks: Seq[CustomClick]

}
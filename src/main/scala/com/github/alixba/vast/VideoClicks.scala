package com.github.alixba.vast

trait VideoClicks extends VASTElement {

  def clicksTracking: Seq[ClickTracking]

  def customClicks: Seq[CustomClick]

}
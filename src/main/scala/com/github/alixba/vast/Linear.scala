package com.github.alixba.vast

trait Linear extends VASTElement {

  def creativeExtensions: Option[Seq[CreativeExtension]]

  def icons: Option[Seq[Icon]]

  def trackingEvents: Option[Seq[Tracking]]

  def videoClicks: Option[VideoClicks]

}

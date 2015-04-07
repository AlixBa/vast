package alixba.vast

import javax.xml.datatype.XMLGregorianCalendar

trait NonLinearAds extends VASTElement {

  def trackingEvents: Option[Seq[Tracking]]

  def nonLinears: Seq[NonLinear]

}

trait NonLinear extends VASTElement {

  def id: Option[String]

  def expandedWidth: Option[Int]

  def expandedHeight: Option[Int]

  def scalable: Option[Boolean]

  def maintainAspectRatio: Option[Boolean]

  def minSuggestedDuration: Option[XMLGregorianCalendar]

  def apiFramework: Option[String]

  def creativeExtensions: Option[Seq[CreativeExtension]]

  def nonLinearClicksTracking: Seq[NonLinearClickTracking]

}

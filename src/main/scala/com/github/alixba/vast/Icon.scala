package com.github.alixba.vast

import javax.xml.datatype.XMLGregorianCalendar

import scala.xml.Node

case class Icon(element: Resource, program: String, width: Int, height: Int, xPosition: String, yPosition: String,
                iconClicks: Option[IconClicks], iconViewTracking: Seq[IconViewTracking],
                offset: Option[XMLGregorianCalendar], duration: Option[XMLGregorianCalendar],
                apiFramework: Option[String]) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val elementXML = element.toXML
    val iconClicksXML = iconClicks.map(_.toXML).toSeq
    val iconViewTrackingXML = iconViewTracking.map(_.toXML)

    <Icon program={ program } width={ width } height={ height } xPosition={ xPosition } yPosition={ yPosition } offset={ offset } duration={ duration } apiFramework={ apiFramework }>{ elementXML }{ iconClicksXML }{ iconViewTrackingXML }</Icon>
  }

}

object Icon extends VASTElementCompanion[Icon] {

  def apply(element: Resource, program: String, width: Int, height: Int, xPosition: String, yPosition: String): Icon =
    Icon(element, program, width, height, xPosition, yPosition, None, Seq.empty, None, None, None)

  /**
   * Deserializes a Node to a T.
   * The highest tag of the Node should match
   * the T.
   *
   * {{{
   *   val elem = <Ad><SomeTags/></Ad>
   *   val ad = Ad.fromXML(elem)
   * }}}
   */
  def fromXML(node: Node): Icon = {
    val element = Resource.fromXML(node)
    val program = (node \ "@program").headOption.getOrElseMissingException("program")
    val width = (node \ "@width").headOption.getOrElseMissingException("width")
    val height = (node \ "@height").headOption.getOrElseMissingException("height")
    val xPosition = (node \ "@xPosition").headOption.getOrElseMissingException("xPosition")
    val yPosition = (node \ "@yPosition").headOption.getOrElseMissingException("yPosition")
    val iconClicks = (node \ "IconClicks").headOption.map(IconClicks.fromXML)
    val iconViewTracking = (node \ "IconViewTracking").toSeq.map(IconViewTracking.fromXML)
    val duration = (node \ "@duration").headOption
    val offset = (node \ "@offset").headOption
    val apiFramework = (node \ "@apiFramework").headOption

    Icon(element, program, width, height, xPosition, yPosition, iconClicks, iconViewTracking, offset, duration, apiFramework)
  }

}
package com.example.vast

import java.net.URI
import javax.xml.datatype.XMLGregorianCalendar

trait IconElement

case class Icon(element: IconElement, program: String, width: Int, height: Int, xPosition: String, yPosition: String,
                iconClicks: Option[IconClicks], iconViewTracking: Seq[URI], offset: Option[XMLGregorianCalendar],
                duration: Option[XMLGregorianCalendar], apiFramework: Option[String])

object Icon {

  def apply(element: IconElement, program: String, width: Int, height: Int, xPosition: String, yPosition: String): Icon =
    Icon(element, program, width, height, xPosition, yPosition, None, Seq.empty, None, None, None)

}
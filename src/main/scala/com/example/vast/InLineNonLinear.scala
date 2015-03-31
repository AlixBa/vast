package com.example.vast

import java.net.URI
import javax.xml.datatype.XMLGregorianCalendar

trait InLineNonLinearElement

case class InLineNonLinear(element: InLineNonLinearElement, width: Int, height: Int,
                           creativeExtensions: Option[Seq[CreativeExtension]], nonLinearClicksTracking: Seq[URI],
                           nonLinearClickThrough: Option[URI], adParameters: Option[AdParameters], id: Option[String],
                           expandedWidth: Option[Int], expandedHeight: Option[Int], scalable: Option[Boolean],
                           maintainAspectRatio: Option[Boolean], minSuggestedDuration: Option[XMLGregorianCalendar],
                           apiFramework: Option[String])

object InLineNonLinear {

  def apply(element: InLineNonLinearElement, width: Int, height: Int): InLineNonLinear =
    InLineNonLinear(element, width, height, None, Seq.empty, None, None, None, None, None, None, None, None, None)

}
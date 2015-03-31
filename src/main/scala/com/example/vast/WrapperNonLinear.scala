package com.example.vast

import java.net.URI
import javax.xml.datatype.XMLGregorianCalendar

case class WrapperNonLinear(creativeExtensions: Option[Seq[CreativeExtension]], nonLinearClickTracking: Seq[URI],
                            id: Option[String], width: Option[Int], height: Option[Int], expandedWidth: Option[Int],
                            expandedHeight: Option[Int], scalable: Option[Boolean], maintainAspectRatio: Option[Boolean],
                            minSuggestedDuration: Option[XMLGregorianCalendar], apiFramework: Option[String])
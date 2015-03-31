package com.example.vast

import java.net.URI

case class StaticResource(value: URI, creativeType: String) extends IconElement with InLineCompanionElement
  with InLineNonLinearElement
package com.example.vast

case class HTMLResource(value: String, xmlEncoded: Option[Boolean]) extends IconElement with InLineCompanionElement
  with InLineNonLinearElement

object HTMLResource {

  def apply(value: String): HTMLResource =
    HTMLResource(value, None)

}
package com.example.vast

case class AdParameters(value: String, xmlEncoded: Option[Boolean])

object AdParameters {

  def apply(value: String): AdParameters =
    AdParameters(value, None)

}
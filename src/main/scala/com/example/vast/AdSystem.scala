package com.example.vast

case class AdSystem(value: String, version: Option[String])

object AdSystem {

  def apply(value: String): AdSystem =
    AdSystem(value, None)

}
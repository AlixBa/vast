package com.example.vast

import java.net.URI

case class ClickTracking(value: URI, id: Option[String])

object ClickTracking {

  def apply(value: URI): ClickTracking =
    ClickTracking(value, None)

}
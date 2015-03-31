package com.example.vast

import java.net.URI

case class Tracking(value: URI, event: Event, offset: Option[String])

object Tracking {

  def apply(value: URI, event: Event): Tracking =
    Tracking(value, event, None)

}
package com.example.vast

import java.net.URI

case class ClickThrough(value: URI, id: Option[String])

object ClickThrough {

  def apply(value: URI): ClickThrough =
    ClickThrough(value, None)

}
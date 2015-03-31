package com.example.vast

import java.net.URI

case class Impression(value: URI, id: Option[String])

object Impression {

  def apply(value: URI): Impression =
    Impression(value, None)

}
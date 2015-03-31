package com.example.vast

import java.net.URI

case class CustomClick(value: URI, id: Option[String])

object CustomClick {

  def apply(value: URI): CustomClick =
    CustomClick(value, None)

}
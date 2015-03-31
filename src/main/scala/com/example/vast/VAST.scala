package com.example.vast

case class VAST(version: String, ads: Seq[Ad])

object VAST {

  def apply(version: String): VAST =
    VAST(version, Seq.empty)
}
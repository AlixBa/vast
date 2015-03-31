package com.example.vast

import java.net.URI

case class MediaFile(value: URI, delivery: Delivery, `type`: String, width: Int, height: Int, id: Option[String],
                     bitrate: Option[Int], minBitrate: Option[Int], maxBitrate: Option[Int], scalable: Option[Boolean],
                     maintainAspectRatio: Option[Boolean], apiFramework: Option[String], codec: Option[String])

object MediaFile {

  def apply(value: URI, delivery: Delivery, `type`: String, width: Int, height: Int): MediaFile =
    MediaFile(value, delivery, `type`, width, height, None, None, None, None, None, None, None, None)

}
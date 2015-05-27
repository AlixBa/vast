package com.github.alixba.vast

import scala.xml.Node

case class MediaFile(value: String, id: Option[String], delivery: Delivery, `type`: String, bitrate: Option[Int],
                     minBitrate: Option[Int], maxBitrate: Option[Int], width: Int, height: Int,
                     scalable: Option[Boolean], maintainAspectRatio: Option[Boolean], apiFramework: Option[String],
                     codec: Option[String]) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <MediaFile id={ id } delivery={ delivery.toString } type={ `type` } bitrate={ bitrate } minBitrate={ minBitrate } maxBitrate={ maxBitrate } width={ width } height={ height } scalable={ scalable } maintainAspectRatio={ maintainAspectRatio } apiFramework={ apiFramework } codec={ codec }>{ value.asCData }</MediaFile>

}

object MediaFile extends VASTElementCompanion[MediaFile] {

  def apply(value: String, delivery: Delivery, `type`: String, width: Int, height: Int): MediaFile =
    MediaFile(value, None, delivery, `type`, None, None, None, width, height, None, None, None, None)

  /**
   * Deserializes a Node to a T.
   * The highest tag of the Node should match
   * the T.
   *
   * {{{
   *   val elem = <Ad><SomeTags/></Ad>
   *   val ad = Ad.fromXML(elem)
   * }}}
   */
  def fromXML(node: Node): MediaFile = {
    val value = node.text
    val id = (node \ "@id").headOption
    val delivery = (node \ "@delivery")
      .headOption.map(n ⇒ Delivery.fromString(n.text)).getOrElseMissingException("delivery")
    val `type` = (node \ "@type").headOption.getOrElseMissingException("type")
    val bitrate = (node \ "@bitrate").headOption
    val minBitrate = (node \ "@minBitrate").headOption
    val maxBitrate = (node \ "@maxBitrate").headOption
    val width = (node \ "@width").headOption.getOrElseMissingException("width")
    val height = (node \ "@height").headOption.getOrElseMissingException("height")
    val scalable = (node \ "@scalable").headOption
    val maintainAspectRatio = (node \ "@maintainAspectRatio").headOption
    val apiFramework = (node \ "@apiFramework").headOption
    val codec = (node \ "@codec").headOption

    MediaFile(value, id, delivery, `type`, bitrate, minBitrate, maxBitrate, width, height, scalable,
      maintainAspectRatio, apiFramework, codec)
  }

}
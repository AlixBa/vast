package alixba.vast

import java.net.URI

import scala.xml.Node

case class MediaFile(value: URI, delivery: Delivery, `type`: String, width: Int, height: Int, id: Option[String],
                     bitrate: Option[Int], minBitrate: Option[Int], maxBitrate: Option[Int], scalable: Option[Boolean],
                     maintainAspectRatio: Option[Boolean], apiFramework: Option[String], codec: Option[String])

object MediaFile extends VASTElement[MediaFile] {

  def apply(value: URI, delivery: Delivery, `type`: String, width: Int, height: Int): MediaFile =
    MediaFile(value, delivery, `type`, width, height, None, None, None, None, None, None, None, None)

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
    val value = URI.create(node.text)
    val delivery = (node \ "@delivery")
      .headOption.map(n ⇒ Delivery.fromString(n.text)).getOrElseMissingException("delivery")
    val `type` = (node \ "@type").headOption.getOrElseMissingException("type")
    val width = (node \ "@width").headOption.getOrElseMissingException("width")
    val height = (node \ "@height").headOption.getOrElseMissingException("height")
    val id = (node \ "@id").headOption
    val bitrate = (node \ "@bitrate").headOption
    val minBitrate = (node \ "@minBitrate").headOption
    val maxBitrate = (node \ "@maxBitrate").headOption
    val scalable = (node \ "@scalable").headOption
    val maintainAspectRatio = (node \ "@maintainAspectRatio").headOption
    val apiFramework = (node \ "@apiFramework").headOption
    val codec = (node \ "@codec").headOption

    MediaFile(value, delivery, `type`, width, height, id, bitrate, minBitrate, maxBitrate, scalable,
      maintainAspectRatio, apiFramework, codec)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: MediaFile): Node =
    <MediaFile delivery={ t.delivery.toString } type={ t.`type` } width={ t.width } height={ t.height } id={ t.id } bitrate={ t.bitrate } minBitrate={ t.minBitrate } maxBitrate={ t.maxBitrate } scalable={ t.scalable } maintainAspectRatio={ t.maintainAspectRatio } apiFramework={ t.apiFramework } codec={ t.codec }>{ t.value.asCData }</MediaFile>

}
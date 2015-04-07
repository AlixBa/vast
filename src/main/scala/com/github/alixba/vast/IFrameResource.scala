package com.github.alixba.vast

import java.net.URI

import scala.xml.Node

case class IFrameResource(value: URI) extends Resource {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <IFrameResource>{ value.asCData }</IFrameResource>

}

object IFrameResource extends VASTElementCompanion[IFrameResource] {

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
  def fromXML(node: Node): IFrameResource =
    IFrameResource(URI.create(node.text))

}


package com.example.vast

import java.net.URI

import scala.xml.Node

case class IFrameResource(value: URI) extends IconElement with InLineCompanionElement with InLineNonLinearElement
  with WrapperCompanionElement

object IFrameResource extends VASTElement[IFrameResource] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: IFrameResource): Node =
    <IFrameResource>{ t.value.asCData }</IFrameResource>

}


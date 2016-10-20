package com.github.alixba.vast

import scala.xml.Node

case class ViewableImpression(viewables: Seq[Viewable], notViewables: Seq[NotViewable],
                              viewsUndetermined: Seq[ViewUndetermined], id: Option[String])
    extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val viewablesXML = viewables.map(_.toXML)
    val notViewablesXML = notViewables.map(_.toXML)
    val viewsUndeterminedXML = viewsUndetermined.map(_.toXML)

    <ViewableImpression id={ id }>{ viewablesXML }{ notViewablesXML }{ viewsUndeterminedXML }</ViewableImpression>
  }

}

object ViewableImpression extends VASTElementCompanion[ViewableImpression] {

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
  def fromXML(node: Node): ViewableImpression = {
    val viewables = (node \ "Viewable").map(Viewable.fromXML)
    val notViewables = (node \ "NotViewable").map(NotViewable.fromXML)
    val viewsUndetermined = (node \ "ViewUndetermined").map(ViewUndetermined.fromXML)
    val id = (node \ "@id").headOption

    ViewableImpression(viewables, notViewables, viewsUndetermined, id)
  }

}
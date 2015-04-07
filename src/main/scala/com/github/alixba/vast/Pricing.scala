package com.github.alixba.vast

import scala.xml.Node

case class Pricing(value: Double, model: Model, currency: String) extends VASTElement {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node =
    <Pricing model={ model.toString } currency={ currency }>{ value }</Pricing>

}

object Pricing extends VASTElementCompanion[Pricing] {

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
  def fromXML(node: Node): Pricing = {
    val value = node.text.toDouble
    val model = (node \ "@model").headOption.map(v ⇒ Model.fromString(v.text)).getOrElseMissingException("model")
    val currency = (node \ "@currency").headOption.getOrElseMissingException("currency")

    Pricing(value, model, currency)
  }

}
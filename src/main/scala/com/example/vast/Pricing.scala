package com.example.vast

import scala.xml.Node

case class Pricing(value: Double, model: Model, currency: String)

object Pricing extends VASTElement[Pricing] {

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

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Pricing): Node =
    <Pricing model={ t.model.toString } currency={ t.currency }>{ t.value }</Pricing>

}
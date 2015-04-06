package alixba.vast

import javax.xml.datatype.XMLGregorianCalendar

import scala.xml.Node

case class WrapperNonLinear(
  creativeExtensions:      Option[Seq[CreativeExtension]],
  nonLinearClicksTracking: Seq[NonLinearClickTracking], id: Option[String], width: Option[Int],
  height: Option[Int], expandedWidth: Option[Int], expandedHeight: Option[Int],
  scalable: Option[Boolean], maintainAspectRatio: Option[Boolean],
  minSuggestedDuration: Option[XMLGregorianCalendar], apiFramework: Option[String]
)

object WrapperNonLinear extends VASTElement[WrapperNonLinear] {

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
  def fromXML(node: Node): WrapperNonLinear = {
    val creativeExtensions = (node \ "CreativeExtensions")
      .headOption.map(n ⇒ (n \ "CreativeExtension").toSeq.map(CreativeExtension.fromXML))
    val nonLinearClicksTracking = (node \ "NonLinearClickTracking").toSeq.map(NonLinearClickTracking.fromXML)
    val id = (node \ "@id").headOption
    val width = (node \ "@width").headOption
    val height = (node \ "@height").headOption
    val expandedWidth = (node \ "@expandedWidth").headOption
    val expandedHeight = (node \ "@expandedHeight").headOption
    val scalable = (node \ "@scalable").headOption
    val maintainAspectRatio = (node \ "@maintainAspectRatio").headOption
    val minSuggestedDuration = (node \ "@minSuggestedDuration").headOption
    val apiFramework = (node \ "@apiFramework").headOption

    WrapperNonLinear(creativeExtensions, nonLinearClicksTracking, id, width, height, expandedWidth, expandedHeight,
      scalable, maintainAspectRatio, minSuggestedDuration, apiFramework)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: WrapperNonLinear): Node = {
    val minSuggestedDurationXML = t.minSuggestedDuration.map(_.toXMLFormat)
    val creativeExtensionsXML = t.creativeExtensions
      .map(n ⇒ <CreativeExtensions>{ n.map(CreativeExtension.toXML) }</CreativeExtensions>).toSeq
    val nonLinearClicksTrackingXML = t.nonLinearClicksTracking.map(NonLinearClickTracking.toXML)

    <NonLinear id={ t.id } width={ t.width } height={ t.height } expandedWidth={ t.expandedWidth } expandedHeight={ t.expandedHeight } scalable={ t.scalable } maintainAspectRatio={ t.maintainAspectRatio } minSuggestedDuration={ minSuggestedDurationXML } apiFramework={ t.apiFramework }>{ creativeExtensionsXML }{ nonLinearClicksTrackingXML }</NonLinear>
  }

}
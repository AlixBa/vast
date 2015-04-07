package alixba.vast

import javax.xml.datatype.XMLGregorianCalendar

import scala.xml.Node

case class WrapperNonLinear(
    creativeExtensions:      Option[Seq[CreativeExtension]],
    nonLinearClicksTracking: Seq[NonLinearClickTracking], id: Option[String], width: Option[Int],
    height: Option[Int], expandedWidth: Option[Int], expandedHeight: Option[Int],
    scalable: Option[Boolean], maintainAspectRatio: Option[Boolean],
    minSuggestedDuration: Option[XMLGregorianCalendar], apiFramework: Option[String]
) extends NonLinear {

  /**
   * Serializes this to a Node.
   */
  def toXML: Node = {
    val minSuggestedDurationXML = minSuggestedDuration.map(_.toXMLFormat)
    val creativeExtensionsXML = creativeExtensions
      .map(n ⇒ <CreativeExtensions>
                 { n.map(_.toXML) }
               </CreativeExtensions>).toSeq
    val nonLinearClicksTrackingXML = nonLinearClicksTracking.map(_.toXML)

    <NonLinear id={ id } width={ width } height={ height } expandedWidth={ expandedWidth } expandedHeight={ expandedHeight } scalable={ scalable } maintainAspectRatio={ maintainAspectRatio } minSuggestedDuration={ minSuggestedDurationXML } apiFramework={ apiFramework }>{ creativeExtensionsXML }{ nonLinearClicksTrackingXML } </NonLinear>
  }

}

object WrapperNonLinear extends VASTElementCompanion[WrapperNonLinear] {

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

}
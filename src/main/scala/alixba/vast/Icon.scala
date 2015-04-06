package alixba.vast

import javax.xml.datatype.XMLGregorianCalendar

import scala.xml.Node

case class Icon(element: IconElement, program: String, width: Int, height: Int, xPosition: String, yPosition: String,
                iconClicks: Option[IconClicks], iconViewTracking: Seq[IconViewTracking],
                offset: Option[XMLGregorianCalendar], duration: Option[XMLGregorianCalendar],
                apiFramework: Option[String])

object Icon extends VASTElement[Icon] {

  def apply(element: IconElement, program: String, width: Int, height: Int, xPosition: String, yPosition: String): Icon =
    Icon(element, program, width, height, xPosition, yPosition, None, Seq.empty, None, None, None)

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
  def fromXML(node: Node): Icon = {
    val element = IconElement.fromXML(node)
    val program = (node \ "@program").headOption.getOrElseMissingException("program")
    val width = (node \ "@width").headOption.getOrElseMissingException("width")
    val height = (node \ "@height").headOption.getOrElseMissingException("height")
    val xPosition = (node \ "@xPosition").headOption.getOrElseMissingException("xPosition")
    val yPosition = (node \ "@yPosition").headOption.getOrElseMissingException("yPosition")
    val iconClicks = (node \ "IconClicks").headOption.map(IconClicks.fromXML)
    val iconViewTracking = (node \ "IconViewTracking").toSeq.map(IconViewTracking.fromXML)
    val duration = (node \ "@duration").headOption
    val offset = (node \ "@offset").headOption
    val apiFramework = (node \ "@apiFramework").headOption

    Icon(element, program, width, height, xPosition, yPosition, iconClicks, iconViewTracking, offset, duration, apiFramework)
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: Icon): Node = {
    val elementXML = IconElement.toXML(t.element)
    val iconClicksXML = t.iconClicks.map(IconClicks.toXML).toSeq
    val iconViewTrackingXML = t.iconViewTracking.map(IconViewTracking.toXML)

    <Icon program={ t.program } width={ t.width } height={ t.height } xPosition={ t.xPosition } yPosition={ t.yPosition } offset={ t.offset } duration={ t.duration } apiFramework={ t.apiFramework }>{ elementXML }{ iconClicksXML }{ iconViewTrackingXML }</Icon>
  }

}

trait IconElement

object IconElement extends VASTElement[IconElement] {

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
  def fromXML(node: Node): IconElement = {
    val html = (node \ "HTMLResource").headOption.map(HTMLResource.fromXML)
    val iframe = (node \ "IFrameResource").headOption.map(IFrameResource.fromXML)
    val static = (node \ "StaticResource").headOption.map(StaticResource.fromXML)

    html.getOrElse(
      iframe.getOrElse(
        static.getOrElseMissingException("HTMLResource", "IFrameResource", "StaticResource")
      )
    )
  }

  /**
   * Serializes a T to a Node.
   */
  def toXML(t: IconElement): Node = {
    t match {
      case h @ HTMLResource(_, _)   ⇒ HTMLResource.toXML(h)
      case i @ IFrameResource(_)    ⇒ IFrameResource.toXML(i)
      case s @ StaticResource(_, _) ⇒ StaticResource.toXML(s)
    }
  }

}
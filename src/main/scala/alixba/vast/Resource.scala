package alixba.vast

import scala.xml.Node

trait Resource extends VASTElement[Resource]

object Resource extends VASTElementCompanion[Resource] {

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
  def fromXML(node: Node): Resource = {
    val html: Option[Resource] = (node \ "HTMLResource").headOption.map(HTMLResource.fromXML)
    val iframe: Option[Resource] = (node \ "IFrameResource").headOption.map(IFrameResource.fromXML)
    val static: Option[Resource] = (node \ "StaticResource").headOption.map(StaticResource.fromXML)

    html.getOrElse(
      iframe.getOrElse(
        static.getOrElseMissingException("HTMLResource", "IFrameResource", "StaticResource")
      )
    )
  }

}
package com.example

import scala.xml.Node

package object vast {

  case class MissingElementException(elems: String*)
    extends RuntimeException(elems.mkString(" or "))

  trait VASTElement[T] {

    /**
     * Deserializes an Node to a T.
     * The highest tag of the Node should match
     * the T.
     *
     * {{{
     *   val elem = <Ad><SomeTags/></Ad>
     *   val ad = Ad.fromXML(elem)
     * }}}
     */
    def fromXML(node: Node): T

    /**
     * Serializes a T to an Node.
     */
    def toXML(t: T): Node

  }

}

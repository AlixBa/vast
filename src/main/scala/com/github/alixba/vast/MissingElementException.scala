package com.github.alixba.vast

/**
 * MissingElementException can be thrown when a mandatory
 * element is missing in the XML.
 */
case class MissingElementException(elems: String*)
  extends RuntimeException(elems.mkString(" or "))
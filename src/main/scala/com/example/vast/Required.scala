package com.example.vast

trait Required

object Required {

  def fromString(value: String): Required = value match {
    case "all"  ⇒ AllType
    case "any"  ⇒ AnyType
    case "none" ⇒ NoneType
  }

}

case object AllType extends Required {
  override def toString = "all"
}

case object AnyType extends Required {
  override def toString = "any"
}

case object NoneType extends Required {
  override def toString = "none"
}
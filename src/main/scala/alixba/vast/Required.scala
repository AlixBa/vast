package alixba.vast

trait Required

object Required {

  def fromString(value: String): Required = value match {
    case "all"  ⇒ AllRequired
    case "any"  ⇒ AnyRequired
    case "none" ⇒ NoneRequired
  }

}

case object AllRequired extends Required {
  override def toString = "all"
}

case object AnyRequired extends Required {
  override def toString = "any"
}

case object NoneRequired extends Required {
  override def toString = "none"
}
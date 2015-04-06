package alixba.vast

trait Model

object Model {

  def fromString(value: String): Model = value match {
    case "cpc" ⇒ CPC
    case "cpm" ⇒ CPM
    case "cpe" ⇒ CPE
    case "cpv" ⇒ CPV
  }

}

case object CPC extends Model {
  override def toString = "cpc"
}

case object CPM extends Model {
  override def toString = "cpm"
}

case object CPE extends Model {
  override def toString = "cpe"
}

case object CPV extends Model {
  override def toString = "cpv"
}
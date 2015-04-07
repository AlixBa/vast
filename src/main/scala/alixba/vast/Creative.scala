package alixba.vast

trait Creative extends VASTElement {

  def element: CreativeElement

  def id: Option[String]

  def sequence: Option[Int]

  def AdID: Option[String]

}

trait CreativeElement extends VASTElement

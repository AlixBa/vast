package com.example.vast

trait InLineCreativeElement

case class InLineCreative(element: InLineCreativeElement, id: Option[String], sequence: Option[Int], AdID: Option[String])

object InLineCreative {

  def apply(element: InLineCreativeElement): InLineCreative =
    InLineCreative(element, None, None, None)

}
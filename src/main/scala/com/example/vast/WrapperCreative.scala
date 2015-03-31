package com.example.vast

trait WrapperCreativeElement

case class WrapperCreative(element: WrapperCreativeElement, id: Option[String], sequence: Option[BigInt], AdID: Option[String])

object WrapperCreative {

  def apply(element: WrapperCreativeElement): WrapperCreative =
    WrapperCreative(element, None, None, None)

}
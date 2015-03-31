package com.example.vast

trait AdElement

case class Ad(element: AdElement, id: Option[String], sequence: Option[Int])
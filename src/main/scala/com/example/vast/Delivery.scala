package com.example.vast

trait Delivery

object Delivery {

  def fromString(value: String): Delivery = value match {
    case "streaming"   ⇒ Streaming
    case "progressive" ⇒ Progressive
  }

}

case object Streaming extends Delivery {
  override def toString = "streaming"
}

case object Progressive extends Delivery {
  override def toString = "progressive"
}
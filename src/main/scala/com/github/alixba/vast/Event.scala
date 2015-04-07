package com.github.alixba.vast

trait Event

object Event {

  def fromString(value: String): Event = value match {
    case "creativeView"     ⇒ CreativeView
    case "start"            ⇒ Start
    case "firstQuartile"    ⇒ FirstQuartile
    case "midpoint"         ⇒ Midpoint
    case "thirdQuartile"    ⇒ ThirdQuartile
    case "complete"         ⇒ Complete
    case "mute"             ⇒ Mute
    case "unmute"           ⇒ Unmute
    case "pause"            ⇒ Pause
    case "rewind"           ⇒ Rewind
    case "resume"           ⇒ Resume
    case "fullscreen"       ⇒ Fullscreen
    case "exitFullscreen"   ⇒ ExitFullscreen
    case "expand"           ⇒ Expand
    case "collapse"         ⇒ Collapse
    case "acceptInvitation" ⇒ AcceptInvitation
    case "close"            ⇒ Close
    case "skip"             ⇒ Skip
    case "progress"         ⇒ Progress
  }

}

case object CreativeView extends Event {
  override def toString = "creativeView"
}

case object Start extends Event {
  override def toString = "start"
}

case object FirstQuartile extends Event {
  override def toString = "firstQuartile"
}

case object Midpoint extends Event {
  override def toString = "midpoint"
}

case object ThirdQuartile extends Event {
  override def toString = "thirdQuartile"
}

case object Complete extends Event {
  override def toString = "complete"
}

case object Mute extends Event {
  override def toString = "mute"
}

case object Unmute extends Event {
  override def toString = "unmute"
}

case object Pause extends Event {
  override def toString = "pause"
}

case object Rewind extends Event {
  override def toString = "rewind"
}

case object Resume extends Event {
  override def toString = "resume"
}

case object Fullscreen extends Event {
  override def toString = "fullscreen"
}

case object ExitFullscreen extends Event {
  override def toString = "exitFullscreen"
}

case object Expand extends Event {
  override def toString = "expand"
}

case object Collapse extends Event {
  override def toString = "collapse"
}

case object AcceptInvitation extends Event {
  override def toString = "acceptInvitation"
}

case object Close extends Event {
  override def toString = "close"
}

case object Skip extends Event {
  override def toString = "skip"
}

case object Progress extends Event {
  override def toString = "progress"
}
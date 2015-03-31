package com.example.vast

case class InLineVideoClicks(clickThrough: Option[ClickThrough], clicksTracking: Seq[ClickTracking],
                             customClicks: Seq[CustomClick])
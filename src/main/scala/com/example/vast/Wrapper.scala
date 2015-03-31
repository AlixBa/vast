package com.example.vast

case class Wrapper(adSystem: AdSystem, vastAdTagURI: VASTAdTagURI, creatives: Seq[WrapperCreative],
                   error: Option[Error], impression: Seq[Impression], extensions: Option[Extensions]) extends AdElement

object Wrapper {

  def apply(adSystem: AdSystem, vastAdTagURI: VASTAdTagURI, creatives: Seq[WrapperCreative]): Wrapper =
    Wrapper(adSystem, vastAdTagURI, creatives, None, Seq.empty, None)

}
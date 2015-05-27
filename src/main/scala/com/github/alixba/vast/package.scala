package com.github.alixba

import scala.xml._

package object vast {

  implicit class RichOption[A](opt: Option[A]) {

    def getOrElseMissingException[B >: A](missing: String*): B = {
      if (opt.isEmpty) throw new MissingElementException(missing: _*)
      else opt.get
    }

  }

  implicit class RichMap(map: Map[String, String]) {

    def asMetaData: MetaData =
      map.foldLeft[MetaData](Null)((acc, mapEntry) ⇒ Attribute(mapEntry._1, Text(mapEntry._2), acc))
  }

  implicit class RichString(str: String) {

    def asCData: PCData =
      PCData(str)

  }

}

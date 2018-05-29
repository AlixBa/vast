name := "VAST"
version := "3.0.8-clickthrough-in-wrapper"
homepage := Some(url("http://github.com/AlixBa/vast"))

organization := "com.github.alixba"
organizationHomepage := Some(url("http://github.com/AlixBa"))

scalaVersion := "2.12.6"
crossScalaVersions := Seq("2.11.12", "2.12.6")

fork in run := true
scalacOptions := Seq(
  "-encoding", "UTF-8", "-deprecation", "-feature", "-unchecked", "-language:implicitConversions",
  "-language:postfixOps", "-Xfuture", "-Xlint"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.scala-lang.modules" %% "scala-xml" % "1.1.0"
)
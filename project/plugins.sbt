resolvers ++= Seq(Resolver.url("bintray-sbt-plugin-releases", url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns))

addSbtPlugin("com.danieltrinh" % "sbt-scalariform" % "1.3.0")

addSbtPlugin("me.lessis" % "bintray-sbt" % "0.2.1")
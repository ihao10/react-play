name := "react-play"

version := "1.0"

lazy val `react-play` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc, cache, javaJpa, json, filters, javaWs,
  "org.mongodb" % "mongodb-driver" % "3.2.2",
  "org.mongodb" % "mongodb-driver-async" % "3.2.2",
  "commons-lang" % "commons-lang" % "2.6",
//  "com.alibaba" % "fastjson" % "1.2.11",
  "org.mongodb.morphia" % "morphia" % "1.2.1"


)

//javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
//resolvers += "maven" at "http://192.168.180.106:8888/nexus/content/repositories/central/"
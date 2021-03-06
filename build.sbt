name := "react-play"

version := "1.0"

lazy val `react-play` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  javaJdbc, cache, javaJpa, json, filters, javaWs,
  "org.mongodb" % "mongodb-driver" % "3.2.2",
  "org.mongodb" % "mongodb-driver-async" % "3.2.2",
  "commons-lang" % "commons-lang" % "2.6",
  "org.mongodb.morphia" % "morphia" % "1.2.1",
  "com.youzu.topsango" % "shared" % "0.1.0"
    exclude("log4j", "log4j")
    exclude("jline", "jline")
)

//javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
resolvers += "maven" at "http://192.168.240.166:8081/nexus/content/repositories/central/"
resolvers += "youzu" at "http://192.168.240.166:8081/nexus/content/repositories/youzu/"
resolvers += "Releases" at "http://192.168.240.166:8081/nexus/content/repositories/releases/"

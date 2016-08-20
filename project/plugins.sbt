logLevel := Level.Info

//resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

//resolvers += "Typesafe repository" at "http://dl.bintray.com/sbt/sbt-plugin-releases/"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Typesafe repository 2" at "https://repo.typesafe.com/typesafe/maven-releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.5")


//
//// Web plugins
//addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")
//addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.0")
//addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.3")
//addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")
//addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.0")
//addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")
//addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.2")
//
//// Play enhancer - this automatically generates getters/setters for public fields
//// and rewrites accessors of these fields to use the getters/setters. Remove this
//// plugin if you prefer not to have this feature, or disable on a per project
//// basis using disablePlugins(PlayEnhancer) in your build.sbt
//addSbtPlugin("com.typesafe.sbt" % "sbt-play-enhancer" % "1.1.0")
//
//// Play Ebean support, to enable, uncomment this line, and enable in your build.sbt using
//// enablePlugins(PlayEbean). Note, uncommenting this line will automatically bring in
//// Play enhancer, regardless of whether the line above is commented out or not.
//addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "3.0.1")
//
//
//// Not necessary but useful for development
//// https://github.com/jamesward/play-auto-refresh
////addSbtPlugin("com.jamesward" % "play-auto-refresh" % "0.0.14")
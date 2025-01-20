lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name := "tenure-cost-and-trade-records-performance-tests",
    version := "2.0.0",
    scalaVersion := "2.13.14",
    //implicitConversions & postfixOps are Gatling recommended -language settings
    scalacOptions ++= Seq("-feature", "-language:implicitConversions", "-language:postfixOps"),
    // Enabling sbt-auto-build plugin provides DefaultBuildSettings with default `testOptions` from `sbt-settings` plugin.
    // These testOptions are not compatible with `sbt gatling:test`. So we have to override testOptions here.
    Test / testOptions := Seq.empty,
    libraryDependencies ++= Dependencies.test
  )

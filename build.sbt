name := "deadbolt-2-usage-scala"

version := "2.5.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

organization := "be.objectify"

libraryDependencies ++= Seq(
  "be.objectify" %% "deadbolt-scala" % "2.5.0"
)

routesGenerator := InjectedRoutesGenerator

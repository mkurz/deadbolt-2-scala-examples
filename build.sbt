name := "deadbolt-2-usage-scala"

version := "2.4.0.1"

lazy val root = (project in file(".")).enablePlugins(play.PlayScala)

scalaVersion := "2.11.6"

organization := "be.objectify"

libraryDependencies ++= Seq(
  "be.objectify" %% "deadbolt-scala" % "2.4.0.1"
)

resolvers += Resolver.sonatypeRepo("snapshots")

routesGenerator := InjectedRoutesGenerator

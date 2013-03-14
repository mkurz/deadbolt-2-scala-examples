import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "deadbolt-2-usage-scala"
    val appVersion      = "2.1-RC1"

    val appDependencies = Seq(
      "be.objectify" %% "deadbolt-scala" % "2.1-RC1"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Change this to point to your local play repository
      resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("Objectify Play Repository - snapshots", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns),
      resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/repo"
    )

}

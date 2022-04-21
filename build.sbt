ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val skfinance = (project in file("."))
  .settings(
    name := "skfinance",
    libraryDependencies ++= Seq(
      "junit" % "junit" % "4.13.2" % Test,
      "org.scalatest" %% "scalatest" % "3.2.11" % Test,
      "org.scalanlp" %% "breeze" % "2.0"
    )
  )

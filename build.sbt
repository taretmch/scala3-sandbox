val scala3Version = "3.0.0-RC3"

ThisBuild / scalaVersion     := scala3Version
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.criceta"
ThisBuild / organizationName := "taretmch"

lazy val docs = project.in(file("docs"))
  .settings(
    mdocVariables := Map(
      "VERSION" -> version.value
    ),
    mdocIn  := file("docs/src/main"),
    mdocOut := file("docs/mdoc")
  )
  .enablePlugins(MdocPlugin)

lazy val root = (project in file("."))
  .settings(
    name := "scala3-sandbox",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )

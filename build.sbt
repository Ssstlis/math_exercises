import com.softwaremill.clippy.ClippySbtPlugin.autoImport.clippyColorsEnabled

addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")

lazy val mathExercises = project
  .in(file("."))
  .settings(
    scalaVersion := "2.12.10",
    scalacOptions := Seq(
      "-Ywarn-unused",
      "-Ywarn-dead-code",
      "-deprecation",
      "-unchecked",
      "-feature",
      "-encoding",
      "utf8"
    ),
    cancelable in Global := true,
    clippyColorsEnabled := true,
    version := "0.1.0",
    fork in run := true,
    sources in(Compile, doc) := Seq.empty,
    publishArtifact in(Compile, packageDoc) := false,
    libraryDependencies ++= Seq(
      "org.scala-lang"    %  "scala-library"       % "2.12.10" pomOnly(),
      "org.scalatest"     %% "scalatest" % "3.0.8" % "test"
    )
  )

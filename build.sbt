name := "Tuto-Play"

version := "1.0-SNAPSHOT"

scalaVersion := Option(System.getProperty("scala.version")).getOrElse("2.11.6")


lazy val root = (project in file(".")).enablePlugins(PlayJava).enablePlugins(PlayEbean);
libraryDependencies ++= Seq(
  "org.webjars"  %% "webjars-play"  % "2.5.0-2",
  "org.webjars"  %  "bootsrap"    % "3.1.1-2",
  "org.webjars"   %  "font-awesome" % "4.6.2",

  javaJdbc,
  cache,
  javaWs
)


name := """EulerPlay"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.xerial" % "sqlite-jdbc" % "3.7.15-M1"
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.27"

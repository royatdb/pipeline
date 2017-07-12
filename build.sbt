import pl.project13.scala.sbt.JmhPlugin

name := "pipeline"

version := "1.0"

scalaVersion := "2.11.11"

resolvers += "bintray-databricks-maven" at "https://dl.bintray.com/databricks/maven"

libraryDependencies += "com.databricks" % "dbml-local" % "0.1.2-spark2.1"

enablePlugins(JmhPlugin)
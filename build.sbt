name := "akka-kafka"

version := "0.1"

scalaVersion := "2.13.3"

lazy val AkkaVersion = "2.6.10"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2"
libraryDependencies += "org.apache.kafka" %% "kafka" % "2.6.0"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.6.0"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
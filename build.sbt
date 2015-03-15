name := "spark-streaming-example"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.2.0"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.2.0"

libraryDependencies += "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.2.0"

// test
libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
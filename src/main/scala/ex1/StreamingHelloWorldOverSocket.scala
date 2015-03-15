package ex1

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingHelloWorldOverSocket extends App {

  val conf = new SparkConf()
    .setMaster("local[*]")
    .setAppName("Simple Streaming")

  val ssc = new StreamingContext(conf, Seconds(1))
  val lines = ssc.socketTextStream("localhost", 9999)
  val lowered = lines.filter(!_.isEmpty).map(_.toLowerCase)
  lowered.print()

  ssc.start()
  ssc.awaitTermination()
}

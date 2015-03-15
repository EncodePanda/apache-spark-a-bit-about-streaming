package ex1

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Run nc -lk 9999 to create a socket server
 * Type words into console and see them printed out back in our driver program
 */
object StreamingHelloWorldOverSocket extends App {

  val conf = new SparkConf()
    .setMaster("local[*]")
    .setAppName("Simple Streaming")

  val ssc = new StreamingContext(conf, Seconds(10))
  val lines = ssc.socketTextStream("localhost", 9999)
  val lowered = lines.filter(!_.isEmpty).map(_.toLowerCase)
  lowered.print()

  ssc.start()
  ssc.awaitTermination()
}

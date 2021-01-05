package test1

import java.time.Duration
import java.util
import java.util.Properties

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.jdk.CollectionConverters._
import scala.language.implicitConversions


case class KafkaConsumeConnector() extends Runnable {

  def run: Unit = {
    readFromKafka("quickstart-events")
  }

  def readFromKafka(topic: String) : Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "145.100.135.102:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("auto.offset.reset","latest")
    props.put("group.id", "consumer-group")
    val consumer : KafkaConsumer[String,String] = new KafkaConsumer[String,String](props)
    consumer.subscribe(util.Arrays.asList(topic))
    while (true) {
      val record = consumer.poll(Duration.ofMillis(1000))
      for (data <- record.iterator.asScala) {
        if (System.cons.contains(data.key())) {
          System.cons(data.key()) ! data.value()
        }
      }
    }
  }
}

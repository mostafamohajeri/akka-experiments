package test1

import java.time.Duration
import java.util
import java.util.Properties

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.jdk.CollectionConverters._
import scala.language.implicitConversions


object KafkaProduceConnector {

  val props = new Properties()
  props.put("bootstrap.servers", "145.100.135.102:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[String,String](props)

  def writeToKafka(topic: String,name: String,value: String) : Unit = {
    val record = new ProducerRecord[String,String](topic,name,value)
    producer.send(record)
  }

}

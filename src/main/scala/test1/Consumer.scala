package test1

import java.time.Duration
import java.util
import java.util.Properties

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.language.implicitConversions
import scala.concurrent.duration._
import scala.jdk.CollectionConverters._


object Consumer {

  def apply()
  : Behavior[String] = Behaviors.setup { (context) =>

    Behaviors.receive { (context, message) => {
     context.log.info(s"${context.self.path.name} : rec : $message")
      Behaviors.same
    }
    }
  }


}

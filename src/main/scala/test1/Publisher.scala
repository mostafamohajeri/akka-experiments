package test1

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object Publisher {

  def apply()
  : Behavior[String] = Behaviors.setup { (context) =>
    context.log.info("I started")
    Behaviors.receive { (context, message) => {
      message match {
        case "send" =>
          test1.KafkaProduceConnector.writeToKafka("quickstart-events",context.self.path.name.replaceAll("p","c"),s"hello from ${context.self.path.name}")
      }
      Behaviors.same
    }
    }
  }
}

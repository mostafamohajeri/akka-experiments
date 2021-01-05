package test1

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

import scala.collection.mutable

object System {

  val pubs : mutable.HashMap[String,ActorRef[String]] = mutable.HashMap[String,ActorRef[String]]()
  val cons : mutable.HashMap[String,ActorRef[String]] = mutable.HashMap[String,ActorRef[String]]()

  def apply()
  : Behavior[String] = Behaviors.receive { (context, message) => {
    message match {
      case "start" =>

        new Thread(KafkaConsumeConnector()).start()

        for(i <- 1 to 1000) {
          pubs += (s"p$i" -> context.spawn(Publisher(), s"p$i"))
        }
        for(i <- 1 to 1000) {
          cons += (s"c$i" -> context.spawn(Consumer(), s"c$i"))
        }



        context.log.info(s"I have ${pubs.size} publishers and ${cons.size} consumers")

        pubs.foreach(p => p._2 ! "send")

    }
    Behaviors.same
  }
  }
}

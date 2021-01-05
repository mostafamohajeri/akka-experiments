package test1

import akka.actor.typed.ActorSystem

object Hello {
    def main(args: Array[String]) = {
        println("Hello, world")
        val system = ActorSystem(System(),"Sys")

        system.tell("start")
    }
}

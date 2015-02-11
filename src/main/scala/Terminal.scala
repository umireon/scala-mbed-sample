package com.github.umireon.scala_mbed_sample

import com.github.jodersky.flow.Serial
import com.github.jodersky.flow.Serial.Opened
import com.github.jodersky.flow.Serial.Received
import com.github.jodersky.flow.SerialSettings

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.io.IO

class Terminal(port: String, settings: SerialSettings) extends Actor {
  import context.system

  IO(Serial) ! Serial.Open(port, settings)

  def receive = {
    case Opened(port) => {
      val operator = sender
      context become opened(operator)
      context watch operator
    }
  }

  def opened(operator: ActorRef): Receive = {
    case Received(data) => {
      print (new String(data.toArray, "UTF-8"))
    }
  }
}

object Terminal {
  def apply(port: String, settings: SerialSettings) = Props(classOf[Terminal], port, settings)
}

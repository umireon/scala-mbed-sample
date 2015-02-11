package com.github.umireon.scala_mbed_sample

import com.github.jodersky.flow.Parity
import com.github.jodersky.flow.SerialSettings

import akka.actor.ActorSystem

object Main {
  def main(args: Array[String]): Unit = {
    val port = args(0)
    val settings = SerialSettings(
      baud = 9600,
      characterSize = 8,
      twoStopBits = false,
      parity = Parity.None
    )

    val system = ActorSystem("flow")
    val terminal = system.actorOf(Terminal(port, settings))
  }
}

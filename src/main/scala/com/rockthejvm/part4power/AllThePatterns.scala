package com.rockthejvm.part4power

import scala.util.{Try, Success}

object AllThePatterns {

  object MySingleton

  // 1 - constants
  val someValue: Any = "Scala"

  val constants = someValue match {
    case 42          => "a number"
    case "Scala"     => "THE Scala"
    case true        => "the thruth"
    case MySingleton => "a singleton object"
  }

  // 2 - match anything
  val matchAnythingVar = someValue match {
    case something => s"I've matched anything, it's ${something}"
  }

  val matchAnything = someValue match {
    case _ => "I can match anything at all"
  }

  // 3 - tuples
  val aTuple = (1, 4)

  val matchTuple = aTuple match {
    case (1, somethingElse) => s"A tuple with 1 and $somethingElse"
    case (something, 2)     => "A tuple with 2 as its second field"
  }

  // PM structures can be NESTED
  val nestedTuple = (1, (2, 3))

  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => "A nested tuple..."
  }

  // 4 - case classes
  val aTry = Try(new RuntimeException())

  val matchList = aTry match {
    case Success(_) => "This is a try"
  }

  // 5 - list patterns
  val aStandardList = List(1, 2, 3, 42)

  val matchStandardList = aStandardList match {
    case List(1, _, _, _)    => "list with 4 elements, first is 1"
    case List(1, _*)         => "list starting with 1"
    case List(1, 2, _) :+ 42 => "list ending in 42"
    case 1 :: tail           => "deconstructed list"
  }

  // 6 - type specifiers
  val unknown: Any = 2

  val matchTyped = unknown match {
    case anInt: Int      => s"I matched an int, I can add 2 to it: ${anInt + 2}"
    case aString: String => "I matched a String"
    case _: Double       => "I matched a double I don't care about"
  }

  // 7 - name binding
  val bindingNames = List(1, 2, 3) match {
    case List(1, 2, rest @ 3) => s"Can use $rest"
  }

  // 8 - chained patterns
  val multiMatch = List(1, 2, 3) match {
    case Nil | List() => "an empty list to me"
  }

  // 9 - if guards
  val secondElementSpecial = List(1, 2, 3) match {
    case List(1, 2, rest @ 3) if rest == 3 => "Third element is big enough"
  }

  def main(args: Array[String]): Unit = {}
}

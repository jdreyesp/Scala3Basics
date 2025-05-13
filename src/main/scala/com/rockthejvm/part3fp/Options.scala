package com.rockthejvm.part3fp

import scala.collection.mutable.ArrayBuffer
import java.util.concurrent.ConcurrentHashMap

object Options {

  // options = "collections" with at most one value
  val anOption: Option[Int]      = Option(42)
  val anEmptyOption: Option[Int] = Option.empty

  val aPresentValue: Option[Int]    = Some(4)
  val anEmptyOption_v2: Option[Int] = None

  // "standard" API
  val isEmpty        = anOption.isEmpty
  val innerValue     = anOption.getOrElse(90)
  val anotherOption  = Option(46)
  val aChainedOption = anEmptyOption.orElse(anotherOption)

  // map, flatMap, filter, for
  val anIncrementedOption = anOption.map(_ + 1)                    // Some(43)
  val aFilteredOption     = anIncrementedOption.filter(_ % 2 == 0) // None
  val aFlatMappedOption   = anOption.flatMap(value => Option(value * 10))

  // work with unsafe API
  def unsafeMethod(): String   = null
  def fallbackMethod(): String = "some valid request"

  // defensive style
  val stringLength = {
    val potentialString = unsafeMethod()
    if (potentialString == null) -1 else unsafeMethod().length
  }

  // option-style
  val stringLengthOption = Option(unsafeMethod()).map(_.length)

  // use-case for orElse
  val someResult = Option(unsafeMethod()).orElse(Option(fallbackMethod()))

  def main(args: Array[String]): Unit = {
    println(stringLength)
    println(stringLengthOption)
    println(aFilteredOption)
    println(aFlatMappedOption)
  }
}

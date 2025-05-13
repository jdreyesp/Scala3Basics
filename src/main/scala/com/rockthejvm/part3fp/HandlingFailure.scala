package com.rockthejvm.part3fp

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object HandlingFailure {

  val aTry: Try[Int] = Try(42)

  val aFailedTry: Try[Int] = Try(
    throw new RuntimeException()
  ) // called by name, so the throw is not evaluated eagerly

  val aTry_v2: Try[Int]       = Success(42)
  val aFailedTry_v2: Try[Int] = Failure(new RuntimeException)

  // main API
  val checkSuccess = aTry.isSuccess
  val checkFailure = aTry.isFailure
  val aChain       = aFailedTry.orElse(aTry)

  // map, flatMap, filter, for comprehensions
  val anIncrementedTry = aTry.map(_ + 1)
  val aFlatMappedTry   = aTry.flatMap(mol => Try(s"My meaning of life is $mol"))

  val aFilteredTry =
    aTry.filter(_ % 2 == 0) // Success(42). If it fails, it throws a NoSuchElementException

  // WHY Try were invented: to avoid unsafe APIs which can THROW exceptions
  def unsafeMethod(): String =
    throw new RuntimeException("No string for you, buster!")

  // defensive: try-catch-finally
  // this can be cumbersome when multiple tries need to be chained
  val stringLengthDefensive =
    try {
      val aString = unsafeMethod()
      aString.length
    } catch {
      case e: RuntimeException => -1
    }

  // purely functional
  val stringLengthPure = Try(unsafeMethod()).map(_.length).getOrElse(-1)

  def main(args: Array[String]): Unit = {}
}

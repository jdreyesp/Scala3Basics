package com.rockthejvm.part3fp

import scala.jdk.CollectionConverters._
import scala.collection.immutable.ListSet
import scala.collection.SortedSet
import scala.collection.immutable.HashSet
import scala.collection.immutable.TreeSet
import java.util.Collections
import scala.collection.immutable.Range.Inclusive
import scala.util.Random
import scala.util.FromDigits.Decimal

object LinearCollections {

  // Seq = well-defined ordering + indexing
  val aSequence                = Seq(1, 2, 3, 4)    // calling the apply function of the companion object of Seq trait
  // main API: index an element
  val thirdElement: Int        = aSequence.apply(2) // element 3
  val reversed                 = aSequence.reverse
  val concatenation: Seq[Int]  = aSequence ++ Seq(5, 6, 7)
  val sortedSequence: Seq[Int] = aSequence.sorted

  val anIncrementedSequence = aSequence.map(_ + 1)
  val aFlatMappedSequence   = aSequence.flatMap(elem => Seq(elem, elem + 1))
  val aFilteredSequence     = aSequence.filter(_ % 2 == 0)

  // List: Same API as Seq
  val aList        = List(1, 2, 3)
  val firstElement = aList.head
  val rest         = aList.tail
  // appending and prepending
  val aBiggerList  = 0 +: aList :+ 4
  val prepending   = 0 :: aList

  val sum       = aSequence.fold(0)((a: Int, acc: Int) => a + acc)
  val stringRep = aSequence.mkString("// ")
  val scalax5   = List.fill(5)("Scala")

  // Ranges
  val aRange: Inclusive         = 1 to 10
  // same seq api but I don't need to have all elements in memory.
  val aNonInclusiveRange: Range = 1 until 10 // 10 not included

  // Arrays
  val anArray =
    Array(1, 2, 3, 4, 5, 6) // backed by Java arrays -> In the end it's an int[] on the JVM

  val arrayAsSequence: Seq[Int] = anArray.toIndexedSeq
  // arrays are mutable
  anArray.update(2, 30) // no new array is allocated

  // Vectors - fast seqs for a large amount of data
  val aVector = Vector(1, 2, 3, 4, 5, 6)
  // the same seq API

  def smallBenchmark(): Unit = {

    // modification time
    val maxRuns     = 1000
    val maxCapacity = 1000000

    def getWriteTime(collection: Seq[Int]): Double = {
      val random = new Random()
      val times  = for {
        _ <- 1 to maxRuns
      } yield {
        val index   = random.nextInt(maxCapacity)
        val element = random.nextInt()

        val currentTime       = System.nanoTime()
        val updatedCollection = collection.updated(index, element)
        System.nanoTime() - currentTime
      }

      // avg
      times.sum * 1.0 / maxRuns
    }

    val numbersList   = (1 to maxCapacity).toList
    val numbersVector = (1 to maxCapacity).toVector

    println(getWriteTime(numbersList))
    println(getWriteTime(numbersVector))
  }

  // Sets
  val aSet                  = Set(1, 2, 3, 4, 5, 4) // no ordering guaranteed, no duplicates
  val contains3: Boolean    = aSet.contains(3)      // same
  val contains3_v2: Boolean = aSet(3)               // same

  // adding / removing
  val aBiggerSet  = aSet + 4 // [1,2,3,4,5]
  val aSmallerSet = aSet - 4 // [1,2,3,5]

  // concatenation
  val anotherSet    = Set(4, 5, 6, 7, 8)
  val muchBiggerSet = aSet.union(anotherSet) // or aSet ++ anotherSet // or aSet | anotherSet

  // difference
  val aDiffSet = aSet.diff(
    anotherSet
  ) // removing all elements from aSet that are in anotherSet (returned in a new set (immutable))

  val intersection = aSet.intersect(anotherSet) // [4, 5] // or aSet & anotherSet

  def main(args: Array[String]): Unit = {
    println(reversed)
    println(concatenation)
    println(sortedSequence)

    println(anIncrementedSequence)
    println(aFlatMappedSequence)
    println(aFilteredSequence)

    println(sum)

    println(stringRep)
    println(scalax5)

    // ranges
    (1 to 10).foreach(_ => println("Scala"))

    // benchmark
    smallBenchmark()

    println(aDiffSet)
  }
}

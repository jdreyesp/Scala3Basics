package com.rockthejvm.part3fp

object TuplesMaps {

  val aTuple       = (2, "rock the jvm") // Tuple2[Int, String]
  val aCopiedTuple = aTuple.copy(_1 = 54)

  // tuples of 2 elements
  val aTuple_2: (Int, String) = 2 -> "rock the jvm"

  // Maps: keys -> values (with no ordering guarantee)
  val aMap = Map()

  val phonebook: Map[String, Int] = Map(
    "Jim"    -> 555,
    "Daniel" -> 789,
    "Jane"   -> 123
  ).withDefaultValue(-1)

  // core APIs
  val phonebookHasDaniel: Boolean = phonebook.contains("Daniel")

  val marysPhoneNumber: Int = phonebook(
    "Mary"
  ) // would crash with an exception if .withDefaultValue is not present

  // add a pair
  val newPair      = "Mary" -> 678
  val newPhonebook = phonebook + newPair

  // remove a key
  val phoneBookWithoutDaniel = phonebook - "Daniel" // new map

  // map to linear collection and vice-versa
  val linearPhonebook = List(
    "Jim"    -> 555,
    "Daniel" -> 789,
    "Jane"   -> 123
  )

  val phonebook_v2       = linearPhonebook.toMap
  val linearPhonebook_v2 = phonebook_v2.toList

  // map, flatMap, filter
  // if I have Map("Jim" -> 123, "jiM" -> 999) => Map("JIM" -> ???) // be careful with mapping a map
  val aProcessedPhonebook = phonebook.map(pair => (pair._1.toUpperCase(), pair._2))

  // api is a little more weird here, we need to convert to a MapView so that it can be filtered.
  val noJs = phonebook.view.filterKeys(!_.startsWith("J")).toMap

  // map values
  val prefixNumbers = phonebook.view.mapValues(number => s"0255-$number").toMap

  // other collections can create maps
  val names        = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  val nameGrouping = names.groupBy(name => name.charAt(0))

  def main(args: Array[String]): Unit = {
    println(phonebookHasDaniel)
    println(marysPhoneNumber)
    println(phonebook + ("Daniel" -> 123)) // updates Daniel

    println(prefixNumbers)
    println(nameGrouping)
  }
}

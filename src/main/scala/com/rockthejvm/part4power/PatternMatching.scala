package com.rockthejvm.part4power

import scala.util.Random

object PatternMatching {

  // switch on steroids
  val random = new Random()
  val aValue = random.nextInt(100)

  val description = aValue match {
    case 1 => "the first"
    case 2 => "the second"
    case 3 => "the third"
    case _ => s"something else: $aValue"
  }

  // decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 16)

  // patterns are matched in order
  // what if no cases match? MatchError
  // What's the type returned? The lowest common ancestor of all type on the RHS of each branch
  val greeting = bob match {
    case Person(n, a)           => s"Hello there, my name is $n and I'm not allowed to say my age"
    case Person(n, a) if a < 18 => s"Hi, my name is $n and I'm $a years old" // a < 18 = guard
    case _                      => "I don't know who I am"
  }

  // Pattern Matching on sealed hierarchies (ADT)
  sealed trait Animal
  case class Dog(breed: String)     extends Animal
  case class Cat(meowStyle: String) extends Animal

  val anAnimal: Animal = Dog("Terra Nova")

  // this warns that the PM could not be exhaustive
  val animalPM = anAnimal match {
    case Dog(someBreed) => "I've detected a dog"
    // case Cat(meowStyle) => "I've detected a cat"
  }

  def main(args: Array[String]): Unit = {
    println(description)
  }
}

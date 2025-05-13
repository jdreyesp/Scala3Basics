package com.rockthejvm.part2oop

object AbstractDataTypes {

  // 1. abstract classes are things
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
    def preferredMeal: String = "anything" // "accessor methods"
  }

  class Dog extends Animal {
    val creatureType                   = "domestic"
    def eat(): Unit                    = println("crunching this bone")
    // overriding is legal for everything
    // overriding with val is only possible when the parent method is a def with no parentheses (no arguments)
    override val preferredMeal: String = "dog food"
  }

  // 2. traits are behaviors
  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {

    override val creatureType: String      = "croc"
    override def eat(): Unit               = println("I'm a crocodile and I'm eating")
    override def eat(animal: Animal): Unit = println("I'm a crocodile and I'm eating this animal")
  }

  // brief intro to the scala type hierarchy
  // 1. Any - the root of the type hierarchy
  // under Any we have AnyVal and AnyRef

  // AnyVal is the supertype of all value types (Int, Boolean, Char, etc.)
  // AnyRef is the supertype of all reference types (String, Lists, etc.)
  // under all anyref we have the null type
  // under Null and Anyval we have the Nothing type

  // the only thing that returns nothing is throwing an exception
  val a: Nothing = throw new Exception("I'm an exception")

  def main(args: Array[String]): Unit = {
    val dog: Animal = new Dog
    dog.eat()
  }
}

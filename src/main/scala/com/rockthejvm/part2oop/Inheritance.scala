package com.rockthejvm.part2oop

object Inheritance {

  @main
  def main() = {

    class Animal {
      val creatureType = "wild"
      def eat(): Unit  = println("nomnomnom")
    }

    class Cat extends Animal {}

    val cat = new Cat
    cat.eat()

    class Person(val name: String, age: Int) {
      def this(name: String) = this(name, 0)
    }

    class Adult(name: String, age: Int, idCard: String)
        extends Person(name, age) {} // must specify super-constructor

    // overriding
    class Dog extends Animal {
      override val creatureType: String = "domestic"
      override def eat(): Unit          = println("mmm, I like this bone")
      // popular overridable method
      override def toString(): String   = "a dog"
    }

    val dog = new Dog
    dog.eat()
    println(dog)

    // subtype polymorphism
    val dog2: Animal = new Dog
    dog2.eat()               // the most specific method will be called
    println(dog2.toString()) // preventing overrides

    class Crocodile extends Animal {
      override val creatureType: String = "very wild"
      override def eat(): Unit          = println("I can eat anything, I'm a croc")
      // different signature = different argument list (different number of args + different arg types)
      def eat(animal: Animal): Unit     = println(s"I'm a croc and I'm eating ${animal.creatureType}")
    }

    val croc = new Crocodile
    croc.eat()
  }
}

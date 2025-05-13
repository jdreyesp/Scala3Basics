package com.rockthejvm.part2oop

object AccessModifiers {

  def main(args: Array[String]): Unit = {

    class Person(val name: String) {
      // protected = accessible from the class and subclasses
      protected def sayHi(): String = s"Hi, my name is $name"
    }

    class Kid(override val name: String, age: Int) extends Person(name) {
      def greetPolitely(): String = {
        sayHi() + ". I love to play!"
      }
    }

    val aPerson = new Person("John")
    val aKid    = new Kid("John", 10)
    println(aKid.greetPolitely())

  }
}

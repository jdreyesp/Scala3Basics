package com.rockthejvm.part2oop

import scala.language.postfixOps

object MethodNotation {

  class Person(val name: String, age: Int, favoriteMovie: String) {
    // infix increases expressiveness on statements
    // infix only works with 1 argument
    infix def likes(movie: String): Boolean = movie == favoriteMovie

    infix def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    // prefix position
    def unary_- : String = s"$name's alter ego"

    // postfix
    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I enjoy $favoriteMovie"
  }

  val mary = new Person("Mary", 34, "Inception")
  val john = new Person("John", 34, "Inception")

  def main(args: Array[String]): Unit = {
    println(mary likes "Fight Club")
    println(mary + john)
  }

  // an operator in scala is basically a plain method!
  println(1.+(2))
  println(1 + 2)

  // prefix
  println(-mary)
  // println(mary.unary_-) // identical

  // postfix
  println(mary isAlive) // discouraged

  // apply is special
  println(mary.apply())
  println(mary())
}

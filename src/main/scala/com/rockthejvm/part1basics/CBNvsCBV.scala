package com.rockthejvm.part1basics

object CBNvsCBV {

  def main(args: Array[String]): Unit = {

    // Calling by value: arguments are evaluated BEFORE the function is called
    def printTwiceByValue(x: Long): Unit = {
      println(x)
      println(x)
    }

    // Calling by name: arguments are passed literally and they will be evaluated at the time they are referenced within the function
    def printTwiceByName(x: => Long): Unit = {
      println(x) // these nanotimes will be different since evaluation happens only at this point
      println(x)
    }

    printTwiceByValue(System.nanoTime())
    printTwiceByName(System.nanoTime())

    // expressions called by name are never evaluated if they are not used in the function, e.g.
    def infinite(i: Int): Int = 1 + infinite(i + 1)

    def takeFirst(a: Int, b: => Int): Int = a

    // this won't crash since infinite(1) is called by name
    println(takeFirst(10, infinite(1)))

  }
}

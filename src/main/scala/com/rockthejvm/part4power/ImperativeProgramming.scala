package com.rockthejvm.part4power

object ImperativeProgramming {

  val meaningOfLife: Int = 42
  // meaningOfLife = 43 // illegal, reassignment to a val

  var aVariable = 99
  aVariable = 100 // vars can be reassigned
  // aVariable = "a string" // this is illegal since once defined, the type of a variable can't change

  aVariable += 10 // aVariable = aVariable + 10
  // aVariable++ // illegal in Scala

  // loops
  def testLoop(): Unit = {
    var i = 0
    while (i < 10) {
      println(s"Counter at $i")
      i += 1
    }
  }

  // imperative programming tradeoffs
  // - risky for concurrency problems (need for concurrnetcy)
  // - harder to understand / debug / test

  // imperative programming can help
  // - for performance-critical applications (0.1% of cases; Akka / ZIO / Cats are already quite fast)
  // - for interactions with Java libraries (usually mutable)
}

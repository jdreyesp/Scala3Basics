package com.rockthejvm.part2oop

object Objects {

  // type + the only instance of this type
  object MySingleton {
    val aField          = 45
    def aMethod(x: Int) = x + 1
  }

  val theSingleton     = MySingleton
  val anotherSingleton = MySingleton
  val isSameSingleton  = theSingleton == anotherSingleton

  val theSingletonField  = MySingleton.aField
  val theSingletonMethod = MySingleton.aMethod(43)

  class Person(name: String) {
    def sayHi() = s"Hi, my name is $name"
  }

  // companions - these fields and methods apply to all person objects - instance-independent functionality - "static"
  object Person {
    val N_EYES            = 2
    def canFly(): Boolean = false
  }

  val john = new Person("John")
  val mary = new Person("Mary")

  // equality
  // 1 - equality of reference
  val samePerson    = john eq mary               // false, different instances
  val sameSingleton = MySingleton eq MySingleton // true

  // 2 - equality of "sameness" - In Java defined by .equals()
  val samePerson_v2    = john.equals(mary)          // false
  val samePerson_v3    = john == mary               // same as .equals()
  val sameSingleton_v2 = MySingleton == MySingleton // true

  // objects can extend classes
  object BigFoot extends Person("Big Foot")

  // Scala application = object + def main(args: Array[String]): Unit
  def main(args: Array[String]): Unit = {
    println(isSameSingleton)
    println(theSingletonField)
    println(theSingletonMethod)
    println(john.sayHi())
    println(mary.sayHi())
    println(BigFoot.sayHi())

  }

}

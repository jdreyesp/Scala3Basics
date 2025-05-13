object WhatsAFunction {

  // FP: functions are "first-class" citizens
  // functions are also values that we can pass around.
  trait MyFunction[A, B] {
    def apply(arg: A): B
  }

  val doubler: MyFunction[Int, Int] = new MyFunction[Int, Int] {
    override def apply(arg: Int): Int = arg * 2
  }

  val meaningOfLife = 42

  // Scala is built on the JVM, and the JVM originally was not designed for FP.
  // with the apply syntactic sugar, we can invoke the value as a function, so we can make it look like a function.
  val meaningDoubled = doubler(meaningOfLife) // doubler.apply(meaningOfLife)

  val doubleStandard = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  val meaningDoubled_v2 = doubleStandard(meaningOfLife)
  // all functions are instnaces of FunctionX with apply method

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  val anAddition = adder(1, 2)

  // the type can be represented as (Int, String, Double, Boolean) => Int
  val aThreeArgFunction = new Function4[Int, String, Double, Boolean, Int] {
    override def apply(v1: Int, v2: String, v3: Double, v4: Boolean): Int = ???
  }

}

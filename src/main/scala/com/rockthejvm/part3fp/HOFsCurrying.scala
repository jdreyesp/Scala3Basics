import scala.annotation.tailrec

object HOFsCurrying {

  // a High order function (HOF) is a function that takes a function as a parameter, or returns a function as a result
  val aHof: (Int, (Int => Int)) => Int = (x, f) => x + 1
  val anotherHof: Int => (Int => Int)  = x => (y => y + 2 * x)

  // quick exercise
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = (x, f) =>
    (i) => f(i.toString, (a) => a % 2 == 0)

  // more examples
  // f(f(f(...(f(x)))))
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n == 0) x
    else nTimes(f, n - 1, f(x))

  // not tail rec so it can stack overflow
  def nTimes_v2(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimes_v2(f, n - 1)(f(x))
  }

  // currying - pass the paramenters one by one
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3: Int => Int              = superAdder(3)
  val invokeSuperAdder: Int         = superAdder(3)(100) // 103

  def curriedFormatter(fmt: String)(x: Double): String = fmt.format(x)

  def main(args: Array[String]): Unit = {
    println(nTimes((x) => x + 1, 3, 0))
    // example of currying
    println(nTimes_v2((x) => x + 1, 10)(0))
    println(invokeSuperAdder)
  }

  def increment(x: Int): Int = x + 1
  val numbers                = List(1, 2, 3)
  val incremented            = numbers.map(increment) // eta-expansion
  val f: Int => Int          = increment              // same as (x: Int) => increment(x) ==> eta-expansion
}

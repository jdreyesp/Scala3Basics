object AnonymousFunctions {

  def main(args: Array[String]): Unit = {
    val doubler: Int => Int = new Function1[Int, Int] {
      override def apply(v1: Int): Int = v1 * 2
    }

    // short-hand notation for Function1[Int, Int]
    // lambdas = anonymous function instances (Alan Touring)
    val doubler_v2: Int => Int   = (x: Int) => x * 2
    val adder: (Int, Int) => Int = (x: Int, y: Int) => x + y

    // zero-arg functions
    val justDoSomething: () => Int = () => 45
    val anInvocation               = justDoSomething()

    // alt syntax with curly braces
    val stringToInt = { (str: String) =>
      // implementation: code block
      str.toInt
    }

    // type inference
    val doubler_v3: Int => Int      = x => x * 2 // type inferred by the compiler
    val adder_v2: (Int, Int) => Int = (x, y) => x + y

    // shortest lambdas
    val doubler_v4: Int => Int      = _ * 2
    val adder_v3: (Int, Int) => Int = _ + _

    println(justDoSomething)
    println(justDoSomething())

  }
}

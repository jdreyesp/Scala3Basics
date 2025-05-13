object StringOps {

  def main(args: Array[String]): Unit = {

    val aString: String = "Hello, I am learning Scala"

    val secondChar      = aString.charAt(1)
    val firstWord       = aString.substring(0, 5)
    val words           = aString.split(" ")
    val startsWithHello = aString.startsWith("Hello")
    val allDashes       = aString.replace(' ', '-')
    val allUppercase    = aString.toUpperCase()
    val nChars          = aString.length

    val reversed      = aString.reverse
    val aBunchOfChars = aString.take(10)

    // s - interpolation
    val name     = "Alice"
    val age      = 12
    val greeting = s"Hello, I'm $name and I'm $age years old"

    // f - interpolation
    val speed = 1.2f
    val myth  = f"$name can eat $speed%2.5f burgers per minute"

    // raw - interpolation
    val escapes = raw"This is a \n newline"

    println(greeting)
    println(myth)
    println(escapes)
  }
}

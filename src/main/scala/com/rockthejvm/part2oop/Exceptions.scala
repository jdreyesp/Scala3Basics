class MyException extends RuntimeException {
  override def getMessage(): String = "MY EXCEPTION"
}

@main
def main() = {

  val potentialFail =
    try {
      throw new RuntimeException("I'm a runtime exception")
    } catch {
      case e: NullPointerException => println("caught a NullPointerException")
      case e: RuntimeException     => println(s"caught exception. Message: ${e.getMessage}")
    } finally {
      println("finally")
    }

  val myException         = new MyException
  val throwingMyException = throw myException
}

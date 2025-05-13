object OOBasics {

  def main(args: Array[String]): Unit = {

    // classes
    class Person(val name: String, age: Int) { // constructor signature
      // fields
      val allCaps = name.toUpperCase()

      // aux constructor
      // the implementation MUST be another constructor call
      def this(name: String) = this(name, 0)

      def this() = this("Jane Doe")

      // methods
      def greet(name: String): Unit =
        println(s"${this.name} says: Hi, $name")
    }

    val aPerson: Person   = new Person("John", 26)
    val john              = aPerson.name
    val johnYelling       = aPerson.allCaps
    val johnSayHiToDaniel = aPerson.greet("Daniel")

    println(john)
    println(johnYelling)

  }

}

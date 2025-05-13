object CaseClasses {

  def main(args: Array[String]): Unit = {
    // case classes can be seen as lightweight data structures
    // all parameters are promoted to fields (so we can access them with dot notation)
    case class Person(name: String, age: Int)

    // 1. class parameters are fields
    val alice = new Person("Alice", 25)
    println(alice.name)

    // 2. sensible toString
    println(alice.toString)
    println(alice)

    // 3. equals and hashCode implemented out of the box
    // equality is based on the fields, not the reference
    val bob = new Person("Bob", 25)
    println(alice == bob)

    // 4. case classes have companion objects
    val thePerson = Person.apply("Bob", 25) // or Person("Bob", 25)
    println(thePerson)

    // 5. case classes are serializable
    // use-case: Akka actor framework

    // 6. case classes have extractor patterns
    case class Car(brand: String, model: String)
    val myCar  = Car("Toyota", "Corolla")
    val myCar2 = Car.apply("Toyota", "Corolla")
    myCar match {
      case Car(brand, model) => println(s"Brand: $brand, Model: $model")
    }

    // 7. case classes have copy method
    val myCar3 = myCar.copy(model = "Camry")
    println(myCar3)

    // case objects
    case object UnitedKingdom {
      def name: String = "The UK of GB and NI"
    }

    // case objects are singleton instances
    println(UnitedKingdom.name)

    // case objects are serializable

    case class CCWithArgListNoArgs[A]() // legal, mainly used in the context of generics
  }

}

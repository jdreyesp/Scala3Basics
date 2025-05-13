object AnonymousClasses {

  abstract class Animal {
    def eat: Unit
  }

  // when we define the creation of a class for a single instance, we can use an anonymous class
  // the compiler creates a class with the name `AnonymousClasses$$anon$1`
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("nomnomnom")
  }

}

object PreventingInheritance {

  class Person(name: String) {
    final def enjoyLife(): Int = 42
  }

  class Adult(name: String) extends Person(name) {
    // override def enjoyLife(): Int = 999 // error: overriding final method enjoyLife in class Person of type ()Int;
  }

  final class Animal
  // class Cat extends Animal // error: class Cat inherits final class Animal;

  // sealing a type hierarchy = inherit from this class in the same file (open for extension but closed for modification)
  sealed class Guitar(nStrings: Int)
  class ElectricGuitar(nStrings: Int) extends Guitar(nStrings)
  class AcousticGuitar(nStrings: Int) extends Guitar(6)

  // no modifier = "not encouraging" inheritance
  // not mandatory, but a good practice
  open class ExtensibleGuitar(nStrings: Int) // open = specifically marked for extension

}

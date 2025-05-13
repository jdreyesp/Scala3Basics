object Generics {

  abstract class MyList[A] {
    def head: A
    def tail: MyList[A]
  }

  class Empty[A] extends MyList[A] {
    override def head: A         = throw new NoSuchElementException
    override def tail: MyList[A] = throw new NoSuchElementException
  }

  class NonEmpty[A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  def main(args: Array[String]): Unit = {
    val list: MyList[Int]     = new NonEmpty(1, new Empty[Int])
    val list2: MyList[String] = new NonEmpty("Hello", new Empty[String])
    println(list.head)
    println(list2.head)
  }

  trait MyMap[Key, Value]

  object MyList {

    def from2Elements[A](elem1: A, elem2: A): MyList[A] =
      new NonEmpty(elem1, new NonEmpty(elem2, new Empty[A]))
  }

  val first2Numbers = MyList.from2Elements(1, 2) // compiler infers that the type is MyList[Int]
}

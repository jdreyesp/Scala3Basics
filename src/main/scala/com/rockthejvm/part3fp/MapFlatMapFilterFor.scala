object MapFlatMapFilterFor {

  // linked list
  val aList          = List(1, 2, 3) // [1] -> [2] -> [3] -> Nil // [1,2,3]
  val firstElement   = aList.head
  val restOfElements = aList.tail

  // map
  val anIncrementedList = aList.map(_ + 1)

  // filter
  val onlyOddNumbers = aList.filter(_ % 2 != 0)

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)

  val aFlatMappedList =
    aList.flatMap(toPair) // [1,2,2,3,3,4] in a single list, that's why it's called flatMap

  // All the possible combinations of all the elements of those lists, in the format "1a - black"
  val numbers = List(1, 2, 3, 4)
  val chars   = List('a', 'b', 'c', 'd')
  val colors  = List("black", "white", "red")

  val allCombinations =
    numbers.flatMap(n => chars.flatMap(c => colors.map(color => s"$n$c - $color")))

  val allCombinations_v2 = for {
    n     <- numbers if n % 2 == 0 // we can add a filter here
    c     <- chars
    color <- colors
  } yield s"$n$c - $color"

  def main(args: Array[String]): Unit = {
    println(allCombinations)
    // println(allCombinations_v2)
  }
}

import com.rockthejvm.part1basics
import scala.annotation.tailrec

object DefaultArgs {

  def main(args: Array[String]): Unit = {

    @tailrec
    // we provide a default value for acc
    def sumTailRec(x: Int, acc: Int = 0): Int = {
      if (x <= 0) acc else sumTailRec(x - 1, acc + x)
    }

    // no need to define acc since it's 0 by default
    println(sumTailRec(100))

    def savePicture(
        dirPath: String = "/",
        name: String,
        format: String = "jpg",
        width: Int = 1920,
        height: Int = 1080
    ): Unit =
      println(s"Saving picture in format $format in path $dirPath")

    // defaults are used
    savePicture("/users/daniel/photos", "myphoto")
    savePicture("/users/daniel/photos", "myphoto", "png")
    // pass values after the default argument
    savePicture("/users/daniel/photos", "myphoto", width = 800, height = 600)
    savePicture(name = "myphoto")
  }
}

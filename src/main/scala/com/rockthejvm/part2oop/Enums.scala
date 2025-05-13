object Enums {

  def main(args: Array[String]): Unit = {
    enum Permissions {
      case READ, WRITE, EXECUTE, NONE
    }

    val readPermission  = Permissions.READ
    val writePermission = Permissions.WRITE

    def openDocument(): Unit =
      if (this == Permissions.READ) println("Opening document...")
      else println("Reading not allowed")

    // enums can have fields, methods, and inner classes
    enum PermissionsWithBits(bits: Int) {
      case READ    extends PermissionsWithBits(4) // 100
      case WRITE   extends PermissionsWithBits(2) // 010
      case EXECUTE extends PermissionsWithBits(1) // 001
      case NONE    extends PermissionsWithBits(0) // 000
    }

    object PermissionsWithBits {

      def fromBits(bits: Int): PermissionsWithBits =
        if (bits == 4) READ
        else if (bits == 2) WRITE
        else if (bits == 1) EXECUTE
        else NONE
    }

    // standard API
    val somePermissionsOrdinal = readPermission.ordinal

    println(somePermissionsOrdinal)
  }
}

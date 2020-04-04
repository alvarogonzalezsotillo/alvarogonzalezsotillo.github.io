

object Solution extends App{

  val in = {
    var ret = new java.util.Scanner(System.in);

    scala.util.Try{
      // EN PRUEBAS LOCALES, LO HAGO CON UN FICHERO
      ret = new java.util.Scanner( new java.io.FileInputStream("nesting-depth.in"))
    }

    ret
  }

  def readInt = in.nextInt()
  def readLine = in.nextLine()

  val T = readLine.toInt
  for( t <- 1 to T ){

    val line = readLine

    var currentDepth = 0;
    var ret = "";

    for( c <- line.toArray.map( c => ("" + c).toInt ) ){
      for( _ <- currentDepth until c ){
        ret += "("
      }
      for( _ <- c until currentDepth ){
        ret += ")"
      }
      ret += c.toString
      currentDepth = c;
    }
    for( _ <- 0 until currentDepth ){
      ret += ")"
    }


    println( s"Case #$t: $ret" )
  }
}

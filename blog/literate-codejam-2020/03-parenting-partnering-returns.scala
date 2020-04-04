

object Solution extends App{



  val in = {
    var ret = new java.util.Scanner(System.in);

    scala.util.Try{
      // EN PRUEBAS LOCALES, LO HAGO CON UN FICHERO
      ret = new java.util.Scanner( new java.io.FileInputStream("parenting-partnering-returns.in"))
    }

    ret
  }


  def readInt = in.nextInt()
  def readLine = in.nextLine()

  case class Task(start:Int,end:Int,inputOrder:Int)


  val T = readLine.toInt
  for( t <- 1 to T ){
    val N = readLine.toInt
    val tasks = Array.tabulate(N){ order =>
      val Array(start,end) = readLine.split(" ").map(_.toInt)
      Task(start,end,order)
    }.sortBy{
      case Task(start,_,_) => start
    }

    var busyC = 0;
    var busyJ = 0;
    var ret = "";
    for( task <- tasks ){
      if( busyC <= task.start ){
        ret +="C";
        busyC = task.end
      }
      else if( busyJ <= task.start ){
        ret +="J";
        busyJ = task.end
      }
      else{
        ret += "I";
      }
    }

    val solution = if( ret.contains("I") ) "IMPOSSIBLE" else {
      val chars : Array[Char] = new Array(tasks.size)
      for( i <- 0 until chars.size ){
        chars(tasks(i).inputOrder) = ret(i)
      }
      chars.mkString("")
    }

    println( s"Case #$t: $solution" )
  }
}

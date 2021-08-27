

object Solution extends App{

  def log( msg : => String ) = {
    // println(msg)
  }

  val in = {
    var ret = new java.util.Scanner(System.in);

    scala.util.Try{
      // EN PRUEBAS LOCALES, LO HAGO CON UN FICHERO
      ret = new java.util.Scanner( new java.io.FileInputStream("02-moons-and-umbrellas.in"))
    }

    ret
  }

  def doit( str: Array[Char], cj: Int, jc: Int ) = {

    def get(index:Int) = if( index < 0 || index >= str.size ) '?' else str(index)

    // TODO ?
    if( str.indexWhere( _ != '?'  ) == -1 ){
      for( i <- 0 until str.size ){
        str(i) = 'C'
      }
    }

    // ALGUNOS NO SON ?
    while( str.indexWhere( _ == '?' ) >= 0 ){
      for( from <- 0 until str.size ){
        val i = str.indexWhere( _ == '?', from )
        if( i >= 0 ){
          log( s"antes: i:$i str:${str.mkString("-")}")
          val prev = get(i-1)
          val next = get(i+1)
          (prev,next) match{
            case ('?','?') => log( "No hago nada" )
            case (a,'?') => str(i) = a
            case ('?',a) => str(i) = a
            case (a,b) => str(i) = a
            case _ => ???
          }
          log( s"despues: i:$i str:${str.mkString("-")}")
        }
      }
    }
  }

  @scala.annotation.tailrec
  def cost( str: Array[Char], cj: Int, jc: Int, from: Int = 0, accum: Int = 0 ) : Int = {
    if( str.size == from+1 )
      accum
    else{
      if( str(from) == 'C' && str(from+1) == 'J' )
        cost( str, cj, jc, from+1, accum + cj)
      else if( str(from) == 'J' && str(from+1) == 'C' )
        cost( str, cj, jc, from+1, accum + jc)
      else
        cost( str, cj, jc, from+1, accum)
    }
  }



  val T = in.nextInt

  for( t <- 1 to T ){
    val X = in.nextInt
    val Y = in.nextInt
    val str = in.nextLine.trim
    val array = str.toArray
    doit(array,X,Y)
    val c = cost( array, X, Y )
    println( s"Case #$t: $c")
  }
}

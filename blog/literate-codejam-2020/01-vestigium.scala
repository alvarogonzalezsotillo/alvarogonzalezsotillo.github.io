

object Solution extends App{

  val in = {
    var ret = new java.util.Scanner(System.in);

    scala.util.Try{
      // EN PRUEBAS LOCALES, LO HAGO CON UN FICHERO
      ret = new java.util.Scanner( new java.io.FileInputStream("vestigium.in"))
    }

    ret
  }

  def readInt = in.nextInt()

  val T = readInt;
  for( t <- 1 to T ){
    val N = readInt
    val rows = Array.fill(N)( new Array[Int](N) )
    val columns = Array.fill(N)( new Array[Int](N) )

    for( row <- 0 until N ; col <- 0 until N ){
      val v = readInt
      rows(row)(col) = v
      columns(col)(row) = v
    }

    def repeated(rowOrColumn: Array[Int]) = {
      val groups = rowOrColumn.groupBy(v=>v)
      val filtered = groups.filter{ case (k,v) => v.size > 1 }
      filtered.size > 0
    }

    val r = rows.filter( repeated ).size
    val c = columns.filter(repeated).size

    val k = (0 until N).map( i => rows(i)(i) ).sum

    println( s"Case #$t: $k $r $c" )
  }
}

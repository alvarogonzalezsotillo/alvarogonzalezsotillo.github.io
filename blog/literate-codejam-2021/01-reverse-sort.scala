

object Solution extends App{

  def log( msg : => String ) = {
    // println(msg)
  }

  val in = {
    var ret = new java.util.Scanner(System.in);

    scala.util.Try{
      // EN PRUEBAS LOCALES, LO HAGO CON UN FICHERO
      ret = new java.util.Scanner( new java.io.FileInputStream("01-reverse-sort.in"))
    }

    ret
  }



  def reverse( list: Array[Int], i: Int, j: Int ) = {
    for( x <- 0 to (j-i)/2 ){
      val temp = list(i+x)
      list(i+x) = list(j-x)
      list(j-x) = temp
    }
  }

  def min( list: Array[Int], i: Int, j: Int ) = {
    val slice = list.slice(i,j)
    val minimum = slice.min
    i + slice.indexWhere( _ == minimum )
  }

  def reverseSort( list: Array[Int] ) = {
    var cost = 0
    log( s"reverseSort:${list.mkString(",")}")
    for( i <- 0 until list.size-1 ){
      val j = min(list,i,list.size);
      val c = j-i+1
      log( s" i:${i} j:${j} c:${c}")
      cost += c
      reverse(list,i,j)
      log( s" after reverse:${list.mkString(",")}")
    }
    cost
  }

  val T = in.nextInt

  for( t <- 1 to T ){
    val N = in.nextInt

    val array = Array.fill(N){
      in.nextInt
    }

    val cost = reverseSort(array)
    println( s"Case #$t: $cost" )
  }
}

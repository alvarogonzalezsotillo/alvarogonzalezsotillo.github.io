

object Solution extends App{

  def log( msg : => String ) = {
    // println(msg)
  }

  val in = {
    var ret = new java.util.Scanner(System.in);

    scala.util.Try{
      // EN PRUEBAS LOCALES, LO HAGO CON UN FICHERO
      ret = new java.util.Scanner( new java.io.FileInputStream("./03-reversort-engineering.in"))
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


  import scala.collection.mutable.{Map => MMap};
  import scala.collection.mutable.{Set => MSet};

  def insert(list: Array[Int], dest: Array[Int], i: Int, value: Int) = {
    log( s"list:${list.size} dest:${dest.size} i:$i value:$value")
    for( x <- 0 until i ){
      dest(x) = list(x)
    }
    dest(i) = value
    for( x <- i until list.size ){
      dest(x+1) = list(x)
    }
  }

  def applyReversions( reversions: Array[Int] ) = {
    val array = Array.tabulate(reversions.size+1)( _+1 )
    for( i <- reversions.size-1 to 0 by -1 ){
      val r = reversions(reversions.size-1-i)
      log( s"i:$i r:$r size:${array.size}")
      assert( r >= 1 )
      assert( i+r <= array.size )
      reverse( array, i, i+r-1 )
      log( s"i:$i r:$r array:${array.mkString("-")}")
    }
    array
  }

  def reversionsUpTo( n: Int, c: Int ) = {
    val ret = new Array[Int](n-1)
    var cost = c
    for( i <- 0 until ret.size ){
      val minRest = ret.size-i-1
      val min = 1
      val max = i+2
      val newCost = (cost-minRest) min max max min
      log( s"   cost:$cost minRest:$minRest min:$min max:$max newCost:$newCost")
      ret(i) = newCost
      cost -= newCost
    }
    ret
  }

  val T = in.nextInt

  for( t <- 1 to T ){
    val N = in.nextInt
    val C = in.nextInt

    if( C < N-1 || C > (N*(N+1)/2-1) ){
      println( s"Case #$t: IMPOSSIBLE")
    }
    else{

      val r = reversionsUpTo(N,C)
      val a = applyReversions( r )

      println( s"Case #$t: ${a.mkString(" ")}")
    }
  }
}

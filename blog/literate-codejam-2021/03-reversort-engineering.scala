

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

  def lameSolution(n: Int, c: Int) : Option[List[Int]]= {
    val array = Array.tabulate(n)( _+1 )

    val list = array.toList

    if( c < n-1 ){
      return None
    }

    if( c > (n*(n+1))/2 ){
      return None
    }

    list.permutations.find( p => reverseSort(p.toArray) == c )
  }

  import scala.collection.mutable.{Map => MMap};
  import scala.collection.mutable.{Set => MSet};

  def memoizeWithIntermediate[A,B]( f: (A,(A)=>B)=>B ) = {
    val memo = MMap[A,B]()
    lazy val ret : (A)=>B = (a:A) => {
      memo.get(a) match{
        case Some(b) => b
        case None => {
          val b = f(a,ret)
          memo(a) = b
          b
        }
      }
    }
    ret
  }


  object compute{
    val map = MMap[ (Int,Int), Array[Int]]()

    def apply( n: Int, c: Int ) : Option[Array[Int]] = {
      val min = n-1
      val max = (n*(n+1))/2 - 1
      if( c < min || c > max ){
        return None
      }

      map.get( (n,c) ) match{
        case Some( seq ) => Some(seq)
        case None => {
          if( n == 1 && c == 0 ){
            Some(Array(1))
          }
          else{
            val prevMin = n-2
            val prevMax = (n-1)*(n)/2-1
            val prevCost = n-c max prevMin min prevMax
            for( pc <- prevCost-2 to prevMax if compute.apply(n-1,pc).isDefined ){
              val prevSeq = compute.apply(n-1,pc).get
              val seq = new Array[Int](n)
              for( i <- 0 until n ){
                insert(prevSeq,seq,i,n)
                val cost = reverseSort(seq)
                if( cost == c ){
                  insert(prevSeq,seq,i,n)
                  map( (n,c) ) = seq
                  return Some(seq)
                }
              }
            }
            println( s"No consigo coste $c para $n" )
            ???
          }
        }
      }
    }
  }

  def insert(list: Array[Int], dest: Array[Int], i: Int, value: Int) = {
    //println( s"list:${list.size} dest:${dest.size} i:$i value:$value")
    for( x <- 0 until i ){
      dest(x) = list(x)
    }
    dest(i) = value
    for( x <- i until list.size ){
      dest(x+1) = list(x)
    }
  }


  def computeSeqForAllCosts(n : Int, intermediate: (Int)=> MMap[Int,Array[Int]]) : MMap[Int,Array[Int]] = {
    if( n == 2 ){
      val ret = MMap[Int,Array[Int]]();
      ret(1) = Array(1,2)
      ret(2) = Array(2,1)
      return ret
    }

    val limit = 1001
    val min = n-1
    val absoluteMax = (n*(n+1))/2 - 1
    val max = absoluteMax min limit
    val num = max-min+1

    val ret = MMap[Int,Array[Int]]()
    val previousSeqs = intermediate(n-1)
    var counter = 0
    var array = new Array[Int](n)
    for( s <- previousSeqs.values ;  i <- 0 until n ){
      counter += 1
      insert(s,array,i,n)
      //println( s"${s.mkString("-")} ${array.mkString("-")}")
      val cost = reverseSort(array)
      if( !ret.contains(cost) && cost <= max ){
        //println( s"cost:$cost clone:${clone.mkString("-")}")
        val clone = new Array[Int](n)
        insert(s,clone,i,n)
        ret(cost) = clone
        if( ret.size == num ){
          //println( s"AHORRO: $counter $n")
          return ret
        }
      }
    }
    ret
  }

  def all() = {
    def printAsSource( n: Int, map: MMap[Int, Array[Int]]) = {
      println( s"$n -> Map(")
      val smap = for( (c,s) <- map ) yield{
        s" $c -> Array( ${s.mkString(",")} )"
      }
      println( smap.mkString(",\n"))
      println("),")
    }

    val memoized = memoizeWithIntermediate(computeSeqForAllCosts)
    for( n <- 2 to 100 ){
      printAsSource(n,memoized(n))
    }
  }

  // for( n <- 99 to 100 ; c <- n-2 to ( (n*(n+1))/2 min 1001) ){
  //   println( s"n:$n c:$c ${compute(n,c).map(_.mkString("-"))}" )
  // }

  all()

  ???


  def test1() = {
    for( i <- 3 to 3 ){
      val list = Array.tabulate(i)( _+1 ).toList
      val ps =  list.permutations
      for( p <- ps )
        println( s"${p.mkString("-")} ${reverseSort(p.toArray)}")
    }
  }

  val T = in.nextInt

  for( t <- 1 to T ){
    val N = in.nextInt
    val C = in.nextInt

    lameSolution(N,C) match{
      case Some(solution) =>  println( s"Case #$t: ${solution.mkString(" ")}" )
      case None => println( s"Case #$t: IMPOSSIBLE" )
    }
  }
}



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

  def ask(p:Int) = {
    println(p)
    readLine.toInt
  }

  val Array(t,b) = readLine.split("""\s+""").map(_.toInt)

  def solveCase(){
    val currentData = new Array[Int](b)

    var counter = 0
    var found = false
    while(!found){
      val min = 0
      val max = b-1
      currentData(min) = ask(min)
      currentData(max) = ask(max)
      counter += 2

      if( counter == 10 ){
        found = true
      }
    }

    println( currentData.mkString("") )
  }

  for( _ <- 1 to t ){
    solveCase()
  }
}

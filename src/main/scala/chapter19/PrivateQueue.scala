package chapter19

class PrivateQueue[T] private (
  private val leading:List[T],
  private val trailing:List[T]
)
  
object PrivateQueue extends App {
  val x= new PrivateQueue[String](List("ameer","ali"), List("azal","ali"))
  
  def apply[T](xs:T*) = new PrivateQueue[T](xs.toList, Nil)


   val y = PrivateQueue(1,2,3)
    
   for(args <-x.trailing;
       xss<-x.leading;
       args2<-y.leading)
   {
     println(args)
     println(xss)
     println(args2)
   }
  
  val xs =  for (
  i <- 1 to 2;
  j <- 1 to 2
) yield (i, j)
   
println(xs)

val xy = for (i <- 1 to 2)
  for (j <- 1 to 2)
    println(i+","+j)
    
    println(xy)

}

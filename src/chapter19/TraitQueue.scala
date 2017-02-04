package chapter19

trait Queue[T] {
  def head:T
  def tail:Queue[T]
  def enqueue(x:T):Queue[T]
}

object Queue {
  def apply[T](xs:T*): Queue[T] = new QueueImpl[T](xs.toList, Nil)
  
  private class QueueImpl[T](private val leading:List[T], private val trailing:List[T]) extends Queue[T] {
    def mirror = if(leading.isEmpty) new QueueImpl(trailing.reverse, Nil) else this
    
    def head: T = mirror.leading.head
   
    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }
    
    def enqueue(x:T) = new QueueImpl(leading, x::trailing)
    
    override def toString = leading.toString + trailing.toString
  }
  
}

object Main extends App {
  
    val variable = Queue(1,2,3,4,5,6)
  
  println(variable.head)
  
  val tail = variable.tail
  
val x = tail.enqueue(5)
 
 println(x)
}
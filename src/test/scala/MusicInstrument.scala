

trait MusicInstrument {
  
  val productionYear :Int
  
}
case class Guitar(productionYear:Int) extends MusicInstrument

case class Piano(productionYear:Int) extends MusicInstrument

class Stack[T] {
    
    var stackSize:Int = 0
    var pointer:Int = -1
    var stackList = List[T]() 
   
    def push(myvar:T) {
      stackList = stackList :+ myvar
      stackSize+=1
      pointer+=1
    }  
    
    def pop():Option[T] = {
      if(stackList == Nil) {
         println("Empty stack")
         return None
      }
      else {
        val x = Some(stackList(pointer))
        pointer-=1
        stackSize-=1
        return x
      }
    
    }
  }

import org.scalatest._
class FirstSpec extends FunSuite with Matchers{  

  test("should implement stack") {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    
    assert(stack.pop.getOrElse(0) === 2)
    assert(stack.pop.getOrElse(0) === 1)
  }
  
    val isVintage:(MusicInstrument => Boolean) = _.productionYear < 1980;
 
 test("should filter vintage guitars") {
    val guitars: List[Guitar] = List(new Guitar(1966), new Guitar(1988))
    val vintageGuitars: List[Guitar] = guitars.filter(isVintage)
    assert(List(new Guitar(1966)) == vintageGuitars)
  }
 
  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }
  
}
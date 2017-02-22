package chapter19

trait MusicInstrument {
  
  val productionYear :Int
  
}
case class Guitar(productionYear:Int) extends MusicInstrument

case class Piano(productionYear:Int) extends MusicInstrument

import org.scalatest._
import collection.mutable.Stack
class FirstSpec extends FunSuite {  
  
 test("dd") {
    
  
    val isVintage:(MusicInstrument => Boolean) = _.productionYear < 1980
    // given
  val guitars: List[Guitar] = List(new Guitar(1966), new Guitar(1988))
  // when
  val vintageGuitars: List[Guitar] = guitars.filter(isVintage)
  // then
  assert(List(new Guitar(1966)) == vintageGuitars)
  }
 
 
  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }
}
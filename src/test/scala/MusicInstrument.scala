package chapter19

trait MusicInstrument {
  
  val productionYear :Int
  
}
case class Guitar(productionYear:Int) extends MusicInstrument

case class Piano(productionYear:Int) extends MusicInstrument

import org.scalatest.FunSuite
class FirstSpec extends FunSuite {  
  val isVintage:(MusicInstrument => Boolean) = _.productionYear < 1980;
 
 test("should filter vintage guitars") {
    val guitars: List[Guitar] = List(new Guitar(1966), new Guitar(1988))
    val vintageGuitars: List[Guitar] = guitars.filter(isVintage)
    assert(List(new Guitar(1966)) == vintageGuitars)
  }
 
  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }
  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }
}
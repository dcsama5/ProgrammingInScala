
import org.scalatest.FunSuite

class Person {
  val name = "Ameer"
}
class Test extends FunSuite{
  test("Simple list test") {
    // Make a list via the companion object factory
val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

// Make a list element-by-element
val when = "AM" :: "PM" :: List()

// Pattern match

def matchString(days:List[String]) {
   days match { 
  case firstDay :: otherDays => {
    println("The first day of the week is: " + firstDay)
    matchString(otherDays)
  }
    
  case List() =>
    println("There don't seem to be any week days.")
  }  
}

matchString(days)


  }
  
  test("name test") {
    val person = new Person()
    assert(person.name == "Ameer1")
  }
}

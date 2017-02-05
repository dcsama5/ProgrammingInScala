package chapter19
class GParent
class Parent extends GParent

class Child extends Parent

class Box[+A]

class Box2[-A]

object Me {
def foo(x : Box[Parent]) : Box[Parent] = identity(x)

def bar(x : Box2[Parent]) : Box2[Parent] = identity(x)
}

object x extends App {
import Me._;

foo(new Box[Child]) // success

//foo(new Box[GParent]) // type error

//bar(new Box2[Child]) // type error

bar(new Box2[GParent]) // success
}

trait Function1[-T1, +R] {

def apply(t : T1) : R

}

object Test1 extends App with Function1[String, Int] {
  
  
  
}
package chapter19

class VendingMachine[+A](val currentItem:Option[A], items:List[A]) {
  
  def this(items:List[A]) = this(None, items)
  
  def dispenseNext(): VendingMachine[A] = 
    items match {
    case Nil => {
      if(currentItem.isDefined)
        new VendingMachine(None, Nil)
      else
        this
    }
    case t :: ts => {
      new VendingMachine(Some(t), ts)
    }
  }
  
  def addAll[B >: A](newItems:List[B]): VendingMachine[B] = 
    new VendingMachine(items ++ newItems)
  
  def get:VendingMachine[A] = this
}

class Drink {
  
}

abstract class SoftDrink extends Drink {
  def name:String
}

abstract class Juice extends Drink {
  def name:String
}

class OrangeJuice extends Juice {
  override def name = "Orange Juice"
}

class Cola extends SoftDrink {
  override def name = "Cola"
}

class TonicWater extends SoftDrink {
  override def name = "Tonic Water"
}

class Shop(var myVendingMachine:VendingMachine[Drink]) {
  
}

object VendingMachine extends App { 

  val myVm:VendingMachine[SoftDrink] = new VendingMachine(List(new Cola, new TonicWater))
  
  val shop = new Shop(myVm)
  
  println(shop.myVendingMachine.dispenseNext.currentItem)

  val colasVm:VendingMachine[Cola] = new VendingMachine(List(new Cola, new Cola))
  
  val softDrinksVM: VendingMachine[Drink] = colasVm.addAll(List(new TonicWater, new OrangeJuice))
  
  var x = softDrinksVM.dispenseNext()
  x = x.dispenseNext()
  x = x.dispenseNext()
  x = x.dispenseNext()
  println(x.currentItem)

}
package chapter19

trait Bullet

class NormalBullet extends Bullet

class ExplosiveBullet extends Bullet

final class AmmoMagazine[+A <: Bullet](private[this] var bullets:List[A]) {
  
  def hasBullets:Boolean = !bullets.isEmpty
  
  def giveNextBullet(): Option[A] = 
      bullets match {
    case Nil => {
      None
    }
    case t :: ts => {
      bullets = ts
      Some(t)
    }
  }
  
}

final class Gun(private var ammoMag:AmmoMagazine[Bullet]) {
  
  def reload(ammoMag:AmmoMagazine[Bullet]):Unit = 
    this.ammoMag = ammoMag
    
  def hasAmmo:Boolean = ammoMag.hasBullets
  
  def shoot():Option[Bullet] = ammoMag.giveNextBullet()
}

object GunMainMethod extends App {
  val gun = new Gun(new AmmoMagazine(List(new NormalBullet, new NormalBullet)))
  
  println(gun.shoot())
  println(gun.hasAmmo)
  println(gun.shoot())
  println(gun.hasAmmo)
}
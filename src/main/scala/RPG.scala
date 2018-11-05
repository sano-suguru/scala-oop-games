import java.util.Random

object RPG {
  val randome = new Random

}

abstract class Creature(var hitPoint: Int, var attackDamage: Int) {
  def isAlive(): Boolean = this.hitPoint > 0
}

class Hero(_hitPoint: Int, _attackDamage: Int) extends Creature(_hitPoint, _attackDamage) {

  def attack(monster: Monster): Unit = {
    monster.hitPoint -= this.attackDamage
    this.hitPoint -= monster.attackDamage
  }

  def escape(monster: Monster): Boolean = {
    val isEscaped = RPG.randome.nextInt(2) == 1
    if (!isEscaped)
      this.hitPoint -= monster.attackDamage
    else
      monster.isAwayFromHero = true
    isEscaped
  }

  override def toString = s"Hero(体力:${hitPoint}, 攻撃力:${attackDamage})"

}

class Monster(_hitPoint: Int, _attackDamage: Int, var isAwayFromHero: Boolean)
  extends  Creature(_hitPoint, _attackDamage) {

  override def toString = s"Monster(体力:${hitPoint}, 攻撃力:${attackDamage}, ヒーローから離れている:${isAwayFromHero})"

}

package pers.chen.game.beans

import pers.chen.game.GameManager
import pers.chen.game.beans.enemy.EnemyBullet
import pers.chen.util.getImage

/**
 * @Author: chen
 * @Date: 2020/3/15 23:39
 * @VERSION 1.0
 *
 */
abstract class AbstractBullet : AbstractGameObject() {

}

private val heroBulletImage = getImage("./images/bullet_hero.png")
private val enemyBulletImage = getImage("./images/bullet_hero.png")

/**
 * 创建一个子弹
 * flag true 英雄子弹
 * flag false 敌人子弹
 */
fun createBullet(x: Double, y: Double, flag: Boolean) {
    createBullet(x, y, 0.0, flag)
}

fun createBullet(x: Double, y: Double, direct: Double, flag: Boolean) {
    val bullet = if (flag) HeroBullet() else EnemyBullet()
    bullet.posInfo.centerX = x
    bullet.posInfo.centerY = y
    bullet.posInfo.direct = direct

    bullet.image = if (flag) heroBulletImage else enemyBulletImage

    GameManager.addObj(bullet)
}

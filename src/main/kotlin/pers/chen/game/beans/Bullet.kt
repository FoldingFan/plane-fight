package pers.chen.game.beans

import javafx.scene.canvas.GraphicsContext
import pers.chen.framwork.GAME_WIDHT
import pers.chen.game.GameManager
import pers.chen.util.getImage

/**
 * @Author: chen
 * @Date: 2020/3/12 10:27
 * @VERSION 1.0
 *
 */
class Bullet : AbstractGameObject() {
    init {
        posInfo.width = 5.0
        posInfo.height = 20.0
        speed = 360.0
    }


    override fun update(nano: Long) {
        if (posInfo.centerX <= -100 || posInfo.centerX >= GAME_WIDHT + 100
                || posInfo.centerY <= -100 || posInfo.centerY >= GAME_WIDHT + 100) {
            GameManager.removeObj(this)
        }
    }

    companion object {
        private val heroBulletImage = getImage("./images/bullet_hero.png")
        private val enemyBulletImage = getImage("./images/bullet_hero.png")

        /**
         * 创建一个子弹
         * flag true 英雄子弹
         * flag false 敌人子弹
         */
        fun createBullet(posInfo: PosInfo, flag: Boolean) {
            createBullet(posInfo.centerX, posInfo.centerY, flag)
        }

        fun createBullet(x: Double, y: Double, flag: Boolean) {
            createBullet(x, y, 0.0, flag)
        }

        fun createBullet(x: Double, y: Double, direct: Double, flag: Boolean) {
            val bullet = Bullet()
            bullet.posInfo.centerX = x
            bullet.posInfo.centerY = y
            bullet.posInfo.direct = direct

            bullet.image = if (flag) heroBulletImage else enemyBulletImage

            GameManager.addObj(bullet)
        }
    }

}



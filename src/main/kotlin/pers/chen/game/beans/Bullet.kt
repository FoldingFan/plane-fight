package pers.chen.game.beans

import javafx.scene.canvas.GraphicsContext
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
        posInfo.height = 5.0

    }

    override fun draw(g: GraphicsContext) {
        g.drawImage(image, posInfo.posX, posInfo.posY, posInfo.width, posInfo.height)
    }

    override fun update(nano: Long) {

    }

    companion object {
        private val heroBullet = getImage("./images/bullet_hero.png")
        private val enemyBullet = getImage("./images/bullet_hero.png")

        /**
         * 创建一个子弹
         * flag true 英雄子弹
         * flag false 敌人子弹
         */
        fun createBullet(posInfo: PosInfo, flag: Boolean) {
            val bullet = Bullet()
            bullet.posInfo.centerX = posInfo.centerX
            bullet.posInfo.centerY = posInfo.centerY
        }
    }

}



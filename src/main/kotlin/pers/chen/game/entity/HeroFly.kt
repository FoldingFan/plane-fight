package pers.chen.game.entity

import pers.chen.game.KeyRecord
import pers.chen.util.getImage

/**
 * @Author: chen
 * @Date: 2020/3/11 21:04
 * @VERSION 1.0
 *
 */
object HeroFly : GameObj() {
    init {
        width = 50.0
        height = 58.0
        centerX = 250.0
        centerY = 250.0
        image = getImage("./images/hero.png")
    }

    override fun update(nano: Long) {
        if (KeyRecord.left) {
            direct = Math.PI
        }
    }
}

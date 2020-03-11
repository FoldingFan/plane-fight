package pers.chen.game.entity

import javafx.scene.canvas.GraphicsContext
import pers.chen.game.GameMain
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
        speed = 10.0
        image = getImage("./images/hero.png")
    }

    override fun draw(graphics: GraphicsContext) {
        graphics.drawImage(image, posX, posY, width, height)
    }

    override fun update(nano: Long) {
        if (KeyRecord.left) {
            direct = Math.PI + Math.PI / 2
        }
        if (KeyRecord.right) {
            direct = Math.PI / 2
        }
    }
}

package pers.chen.game.entity

import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
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
        speed = 66.0
        image = getImage("./images/hero.png")
    }

    /**
     * 按键更新，当方向键变更时触发
     */
    fun directUpdate() {

    }

    override fun draw(graphics: GraphicsContext) {
        graphics.drawImage(image, posX, posY, width, height)
    }

    override fun update(nano: Long) {

    }
}

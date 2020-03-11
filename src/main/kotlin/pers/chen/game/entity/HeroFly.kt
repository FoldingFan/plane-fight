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
        speed = 60.0
        image = getImage("./images/hero.png")
    }

    override fun draw(graphics: GraphicsContext) {
        graphics.drawImage(image, posX, posY, width, height)
    }

    override fun update(nano: Long) {

    }

    fun keyPress(keyEvent: KeyEvent) {
        when (keyEvent.code) {
            KeyCode.A -> direct += Math.PI + Math.PI / 2
            KeyCode.S -> direct += Math.PI
            KeyCode.D -> direct += Math.PI / 2
            else -> {
            }
        }
    }

    fun keyRelease(keyEvent: KeyEvent) {
        when (keyEvent.code) {
            KeyCode.A -> direct -= Math.PI + Math.PI / 2
            KeyCode.S -> direct -= Math.PI
            KeyCode.D -> direct -= Math.PI / 2
            else -> {
            }
        }
    }
}

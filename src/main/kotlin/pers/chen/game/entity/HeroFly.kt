package pers.chen.game.entity

import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import pers.chen.game.KeyPress
import pers.chen.game.enums.MoveState
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
    fun updateDirect() {
        if (KeyPress.up) direct = 0.0
        if (KeyPress.down) direct = Math.PI
        if (KeyPress.left) direct = Math.PI / 2 + Math.PI
        if (KeyPress.right) direct = Math.PI / 2
        if (KeyPress.up && KeyPress.left) direct = Math.PI * 2 - Math.PI / 4
        if (KeyPress.up && KeyPress.right) direct = Math.PI / 4
        if (KeyPress.down && KeyPress.left) direct = Math.PI + Math.PI / 4
        if (KeyPress.down && KeyPress.right) direct = Math.PI - Math.PI / 4
    }

    override fun draw(graphics: GraphicsContext) {
        graphics.drawImage(image, posX, posY, width, height)
    }

    override fun update(nano: Long) {
        if (!KeyPress.right && !KeyPress.left && !KeyPress.up && !KeyPress.down && speed > 0) {
            speed--
        }
    }
}

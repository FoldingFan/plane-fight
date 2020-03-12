package pers.chen.game.beans

import javafx.scene.canvas.GraphicsContext
import pers.chen.game.KeyPress
import pers.chen.util.getImage

/**
 * @Author: chen
 * @Date: 2020/3/11 21:04
 * @VERSION 1.0
 * 英雄飞机
 */
object HeroFly : AbstractPlaneObject() {
    init {
        posInfo.width = 50.0
        posInfo.height = 58.0
        posInfo.centerX = 250.0
        posInfo.centerY = 250.0
        bulletOnSec = 10.0
        image = getImage("./images/hero.png")
    }

    /**
     * 按键更新，当方向键变更时触发
     */
    fun updateDirect() {
        if (KeyPress.up) posInfo.direct = 0.0
        if (KeyPress.down) posInfo.direct = Math.PI
        if (KeyPress.left) posInfo.direct = Math.PI / 2 + Math.PI
        if (KeyPress.right) posInfo.direct = Math.PI / 2
        if (KeyPress.up && KeyPress.left) posInfo.direct = Math.PI * 2 - Math.PI / 4
        if (KeyPress.up && KeyPress.right) posInfo.direct = Math.PI / 4
        if (KeyPress.down && KeyPress.left) posInfo.direct = Math.PI + Math.PI / 4
        if (KeyPress.down && KeyPress.right) posInfo.direct = Math.PI - Math.PI / 4
    }

    override fun fire() {
        Bullet.createBullet(posInfo, true)
    }


    override fun draw(graphics: GraphicsContext) {
        graphics.drawImage(image, posInfo.posX, posInfo.posY, posInfo.width, posInfo.height)
    }

    override fun update(nano: Long) {
        /*开火*/
        if (KeyPress.fire) super.isFire()
        /*方向*/
        if (!KeyPress.right && !KeyPress.left && !KeyPress.up && !KeyPress.down) {
            if (speed > 0.0) {
                speed -= speed / 10
                speed = if (speed.compareTo(10) < 0) 0.0 else speed
            }
        } else if (speed < 180) {
            speed += (180 - speed) / 10
            speed = if (speed >= 170.0) 180.0 else speed
        }
    }
}

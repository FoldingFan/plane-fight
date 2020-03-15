package pers.chen.game.beans

import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image

/**
 * @Author: chen
 * @Date: 2020/3/11 20:57
 * @VERSION 1.0
 * 游戏对象
 */
abstract class AbstractGameObject : AbstractMoveObject() {

    /*游戏所用图片*/
    var image: Image? = null

    /*碰撞体积*/
    var hitWidth = 0.0

    /*发生碰撞*/
    abstract fun collision(gameObject: AbstractGameObject)

    open fun draw(graphics: GraphicsContext) {
        graphics.save()
        graphics.translate(posInfo.centerX, posInfo.centerY)
        graphics.rotate(180 / Math.PI * posInfo.direct)
        graphics.drawImage(image, -posInfo.width / 2, -posInfo.height / 2, posInfo.width, posInfo.height)
        graphics.restore()
    }

    abstract fun update(nano: Long)
}

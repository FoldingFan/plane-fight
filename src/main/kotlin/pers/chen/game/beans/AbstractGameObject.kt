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

    abstract fun draw(g: GraphicsContext)
    abstract fun update(nano: Long)


}

package pers.chen.game.entity

import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import pers.chen.game.GameCoroutines
import kotlin.math.cos
import kotlin.math.sin

/**
 * @Author: chen
 * @Date: 2020/3/11 20:57
 * @VERSION 1.0
 * 游戏对象
 */
abstract class GameObj {
    val posInfo = PosInfo()

    /*游戏所用图片*/
    var image: Image? = null
    abstract fun draw(g: GraphicsContext)
    abstract fun update(nano: Long)
}

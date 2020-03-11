package pers.chen.game.base

import javafx.scene.image.Image

/**
 * @Author: chen
 * @Date: 2020/3/11 20:57
 * @VERSION 1.0
 * 游戏对象
 */
abstract class GameObj {
    var image: Image? = null

    /*每秒移动距离*/
    var speed: Int = 5

    /*宽高，设置宽高会导致中心点变化*/
    var width: Double = 0.0
        set(value) {
            field = value
            centerX = posX + value / 2
        }
    var height: Double = 0.0
        set(value) {
            field = value
            centerY = posY + value / 2
        }

    /*位置信息 左上角坐标 */
    var posX: Double = 0.0
        set(value) {
            field = value
            if (centerX != value + width / 2) centerX = value + width / 2
        }
    var posY: Double = 0.0
        set(value) {
            field = value
            if (centerY != value + height / 2) centerY = value + height / 2
        }

    /*位置信息 中心点坐标 设置中心点 改变也会改变左上角左边*/
    var centerX: Double = 0.0
        set(value) {
            field = value
            if (posX != value - width / 2) posX = value - width / 2
        }
    var centerY: Double = 0.0
        set(value) {
            field = value
            if (posY != value - height / 2) posY = value - height / 2
        }

    /*旋转角度*/
    var rota: Double = 0.0
        set(value) {
            field = value % Math.PI
        }


    abstract fun update()
}

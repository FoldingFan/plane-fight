package pers.chen.game.entity

/**
 * @Author: chen
 * @Date: 2020/3/12 10:35
 * @VERSION 1.0
 * 物体信息
 */
class PosInfo {
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

    /*方向*/
    var direct: Double = 0.0
        set(value) {
            field = value % (Math.PI * 2)
        }
}

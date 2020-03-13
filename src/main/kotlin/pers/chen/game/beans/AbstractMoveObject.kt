package pers.chen.game.beans

import pers.chen.framwork.MainThread
import kotlin.math.cos
import kotlin.math.sin

/**
 * @Author: chen
 * @Date: 2020/3/12 10:37
 * @VERSION 1.0
 * 可移动物体
 */
abstract class AbstractMoveObject {
    val posInfo = PosInfo()

    /*每秒移动距离*/
    var speed: Double = 0.0
        set(value) {
            field = value
            moveNanos = value / 1E9
        }


    /*每纳秒移动距离*/
    private var moveNanos = 0.0
    fun move(useNano: Long) {
        posInfo.centerX += sin(posInfo.direct) * moveNanos * useNano
        posInfo.centerY -= cos(posInfo.direct) * moveNanos * useNano
    }
}

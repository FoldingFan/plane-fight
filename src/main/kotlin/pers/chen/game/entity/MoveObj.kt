package pers.chen.game.entity

import pers.chen.game.GameCoroutines
import kotlin.math.cos
import kotlin.math.sin

/**
 * @Author: chen
 * @Date: 2020/3/12 10:37
 * @VERSION 1.0
 * 可移动物体
 */
abstract class MoveObj : GameObj() {
    /*每秒移动距离*/
    var speed: Double = 0.0
        set(value) {
            field = value
            speedFrame = if (value != 0.0) value / GameCoroutines.fps else 0.0
        }

    /*每帧移动距离*/
    private var speedFrame = 0.0

    /*状态*/
    fun move() {
        posInfo.centerX += sin(posInfo.direct) * speedFrame
        posInfo.centerY -= cos(posInfo.direct) * speedFrame
    }
}

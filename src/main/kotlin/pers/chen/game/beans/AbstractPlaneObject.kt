package pers.chen.game.beans

import pers.chen.framwork.MainCoroutines

/**
 * @Author: chen
 * @Date: 2020/3/12 10:31
 * @VERSION 1.0
 *
 */
abstract class AbstractPlaneObject : AbstractGameObject() {
    /*一秒发射多少子弹*/
    var bulletOnSec = 0.0
        set(value) {
            field = value
            bulletFrame = value / MainCoroutines.fps
        }

    /*一帧多少发子弹*/
    private var bulletFrame = 0.0

    private var frame = 0.0
    fun isFire() {
        frame += bulletFrame
        if (frame >= 1) {
            frame -= 1
            fire()
        }
    }

    /*开火一次*/
    abstract fun fire()
}

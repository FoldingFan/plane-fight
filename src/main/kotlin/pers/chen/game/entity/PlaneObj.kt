package pers.chen.game.entity

import pers.chen.game.GameCoroutines

/**
 * @Author: chen
 * @Date: 2020/3/12 10:31
 * @VERSION 1.0
 *
 */
abstract class PlaneObj : MoveObj() {
    /*一秒发射多少子弹*/
    var bullet = 0.0
        set(value) {
            field = value
            bulletFrame = GameCoroutines.fps / value
        }

    /*多少帧一发子弹*/
    private var bulletFrame = 0.0
    abstract fun fire()
}

package pers.chen.game.beans

import pers.chen.framwork.MainThread

/**
 * @Author: chen
 * @Date: 2020/3/12 10:31
 * @VERSION 1.0
 *
 */
abstract class AbstractPlaneObject : AbstractGameObject() {
    /*一秒发射多少子弹*/
    var bulletOnSec = 0.0

    /*累计间隔*/
    private var ex = 0.0
    fun isFire(useNanos: Long) {
        ex += useNanos
        if (ex >= 1E9 / bulletOnSec) {
            ex -= 1E9 / bulletOnSec
            fire()
        }
    }

    /*开火一次*/
    abstract fun fire()
}

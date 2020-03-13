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
        set(value) {
            field = value
            fireNanos = 1E9 / field
        }


    /*累计间隔*/
    private var ex = 0.0

    /*多少纳米发射一枚子弹*/
    private var fireNanos = 0.0
    fun isFire(useNanos: Long) {
        ex += useNanos
        if (ex >= fireNanos) {
            ex -= fireNanos
            fire()
        }
    }

    /*开火一次*/
    abstract fun fire()
}

package pers.chen.framwork

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * @Author: chen
 * @Date: 2020/3/11 19:21
 * @VERSION 1.0
 *  游戏主线程
 */
object GameCoroutines {
    private var elapsedNano: Long = 0
    private var preNano: Long? = null
    private var fps: Long = 0
        set(value) {
            field = value
            nps = (1E9 / field).toLong()
        }
    private var nps: Long = 0

    init {
        fps = 60
    }

    /*开始游戏*/
    fun play() {
        GlobalScope.launch {
            while (true) {
                val currNano = System.nanoTime()
                preNano = preNano ?: currNano
                elapsedNano += currNano - preNano!!
                if (elapsedNano >= nps) {
                    ViewManager.currView?.onUpdate(elapsedNano)
                    elapsedNano -= nps
                }
                preNano = currNano
            }
        }
    }
}

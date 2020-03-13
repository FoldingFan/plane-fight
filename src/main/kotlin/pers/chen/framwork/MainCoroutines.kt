package pers.chen.framwork

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

/**
 * @Author: chen
 * @Date: 2020/3/11 19:21
 * @VERSION 1.0
 *  主协程
 */
object MainCoroutines {


    /*设置的fps*/
    var fps: Long = 0
        set(value) {
            field = value
            nps = (1E9 / field).toLong()
        }

    /*实际的Fps*/
    var realFps = 0


    private var elapsedNano: Long = 0
    private var preNano: Long? = null
    private var nps: Long = 0

    /*统计真实fps*/
    private val fpsArray = arrayListOf<Long>()

    init {
        fps = 60
    }

    private fun realFpsCalc(elapsedNano: Long) {
        fpsArray.add(elapsedNano)
        if (fpsArray.size == fps.toInt()) {
            val nanoFrame = fpsArray.average()
            realFps = (1E9 / nanoFrame).roundToInt()
            fpsArray.clear()
        }
    }

    /*游戏线程开始*/
    fun play() {
        GlobalScope.launch {
            while (true) {
                val currNano = System.nanoTime()
                preNano = preNano ?: currNano
                elapsedNano += currNano - preNano!!
                if (elapsedNano >= nps) {
                    ViewManager.currView?.onUpdate(elapsedNano)
                    realFpsCalc(elapsedNano)
                    elapsedNano -= nps
                }
                preNano = currNano
            }
        }
    }
}

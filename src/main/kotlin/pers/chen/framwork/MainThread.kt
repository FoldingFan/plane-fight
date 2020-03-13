package pers.chen.framwork

import javafx.animation.AnimationTimer
import kotlin.math.roundToInt

/**
 * @Author: chen
 * @Date: 2020/3/11 19:21
 * @VERSION 1.0
 *  主线程
 */
object MainThread : AnimationTimer() {
    /*统计真实fps*/
    private val fpsArray = arrayListOf<Long>()
    private var preNano: Long = 0
    var realFps: Int = 0


    private fun realFpsCalc(useNano: Long) {
        fpsArray.add(useNano)
        if (fpsArray.size == 60) {
            val nanoFrame = fpsArray.average()
            println("$useNano : ${nanoFrame.toLong()}")
            fpsArray.clear()
        }
    }

    /*游戏线程开始*/
    fun play() {
        start()
    }

    override fun handle(now: Long) {
        val useNano = now - preNano
        realFpsCalc(useNano)
        ViewManager.currView?.onUpdate(useNano)
        preNano = now
    }
}

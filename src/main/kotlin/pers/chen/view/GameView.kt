package pers.chen.view

import pers.chen.base.BaseView

/**
 * @Author: chen
 * @Date: 2020/3/11 18:58
 * @VERSION 1.0
 *
 */
object GameView : BaseView() {

    private var s = 0
    override fun onUpdate(nanos: Long) {
        if (++s >= 60) {
            s = 0
            println("60次执行")
        }
    }

}

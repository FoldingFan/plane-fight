package pers.chen.view

import pers.chen.base.BaseView
import pers.chen.game.GameMain
import pers.chen.game.canvas

/**
 * @Author: chen
 * @Date: 2020/3/11 18:58
 * @VERSION 1.0
 *
 */
object GameView : BaseView() {
    init {
        pane.children.add(canvas)
    }

    override fun onUpdate(nanos: Long) {
        GameMain.run(nanos)
    }

}

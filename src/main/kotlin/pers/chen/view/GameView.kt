package pers.chen.view

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
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

    override fun onKeyPress(it: KeyEvent) {
        when (it.code) {
            KeyCode.A -> GameMain.left()
            KeyCode.D -> GameMain.right()
            KeyCode.W -> GameMain.up()
            KeyCode.S -> GameMain.down()
            else -> {
            }
        }
    }

    override fun onUpdate(nanos: Long) {
        GameMain.run(nanos)
    }

}

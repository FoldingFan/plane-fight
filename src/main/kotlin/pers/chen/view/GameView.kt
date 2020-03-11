package pers.chen.view

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import pers.chen.base.BaseView
import pers.chen.game.GameLogic
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
        pane.children.add(GameMain.canvas)
    }

    override fun onKeyPress(it: KeyEvent) {
        when (it.code) {
            KeyCode.A -> GameLogic.left()
            KeyCode.D -> GameLogic.right()
            KeyCode.W -> GameLogic.up()
            KeyCode.S -> GameLogic.down()
            else -> {
            }
        }
    }

    override fun onUpdate(nanos: Long) {
        GameMain.run(nanos)
    }

}

package pers.chen.view

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import pers.chen.base.BaseView
import pers.chen.game.GameKeyHandler
import pers.chen.game.GameMain

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

    override fun onKeyPress(it: KeyEvent) = when (it.code) {
        KeyCode.A -> GameKeyHandler.left = true
        KeyCode.D -> GameKeyHandler.right = true
        KeyCode.W -> GameKeyHandler.up = true
        KeyCode.S -> GameKeyHandler.down = true
        else -> {
            println("点击一次")
        }
    }

    override fun onKeyRelease(it: KeyEvent) = when (it.code) {
        KeyCode.A -> GameKeyHandler.left = false
        KeyCode.D -> GameKeyHandler.right = false
        KeyCode.W -> GameKeyHandler.up = false
        KeyCode.S -> GameKeyHandler.down = false
        else -> {
            println("点击释放")
        }
    }

    override fun onUpdate(nanos: Long) {
        /*运行游戏主逻辑*/
        GameMain.run(nanos)
    }

}

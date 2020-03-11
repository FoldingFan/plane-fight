package pers.chen.view

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import pers.chen.game.KeyHandler
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
        KeyCode.A -> KeyHandler.left = true
        KeyCode.D -> KeyHandler.right = true
        KeyCode.W -> KeyHandler.up = true
        KeyCode.S -> KeyHandler.down = true
        else -> {
            println("点击一次")
        }
    }

    override fun onKeyRelease(it: KeyEvent) = when (it.code) {
        KeyCode.A -> KeyHandler.left = false
        KeyCode.D -> KeyHandler.right = false
        KeyCode.W -> KeyHandler.up = false
        KeyCode.S -> KeyHandler.down = false
        else -> {
            println("点击释放")
        }
    }

    override fun onUpdate(nanos: Long) {
        /*运行游戏主逻辑*/
        GameMain.run(nanos)
    }

}

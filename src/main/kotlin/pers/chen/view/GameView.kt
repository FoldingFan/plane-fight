package pers.chen.view

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import pers.chen.game.GameManager
import pers.chen.game.KeyPress

/**
 * @Author: chen
 * @Date: 2020/3/11 18:58
 * @VERSION 1.0
 *
 */
object GameView : BaseView() {
    init {
        pane.children.add(GameManager.canvas)
    }

    override fun onKeyPress(it: KeyEvent) = when (it.code) {
        KeyCode.A -> KeyPress.left = true
        KeyCode.D -> KeyPress.right = true
        KeyCode.W -> KeyPress.up = true
        KeyCode.S -> KeyPress.down = true
        KeyCode.J -> KeyPress.fire = true
        else -> {
        }
    }

    override fun onKeyRelease(it: KeyEvent) = when (it.code) {
        KeyCode.A -> KeyPress.left = false
        KeyCode.D -> KeyPress.right = false
        KeyCode.W -> KeyPress.up = false
        KeyCode.S -> KeyPress.down = false
        KeyCode.J -> KeyPress.fire = false
        else -> {
        }
    }

    override fun onUpdate(useNano: Long) {
        /*运行游戏主逻辑*/
        GameManager.run(useNano)
    }

}

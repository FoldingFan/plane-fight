package pers.chen.view

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import pers.chen.game.KeyRecord
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
        KeyCode.A -> KeyRecord.left = true
        KeyCode.D -> KeyRecord.right = true
        KeyCode.W -> KeyRecord.up = true
        KeyCode.S -> KeyRecord.down = true
        else -> {
            println("点击一次")
        }
    }

    override fun onKeyRelease(it: KeyEvent) = when (it.code) {
        KeyCode.A -> KeyRecord.left = false
        KeyCode.D -> KeyRecord.right = false
        KeyCode.W -> KeyRecord.up = false
        KeyCode.S -> KeyRecord.down = false
        else -> {
            println("点击释放")
        }
    }

    override fun onUpdate(nanos: Long) {
        /*运行游戏主逻辑*/
        GameMain.run(nanos)
    }

}

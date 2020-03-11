package pers.chen.view

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import pers.chen.game.GameMain
import pers.chen.game.entity.HeroFly

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
        HeroFly.keyPress(it)
    }

    override fun onKeyRelease(it: KeyEvent) {
        HeroFly.keyRelease(it)
    }

    override fun onUpdate(nanos: Long) {
        /*运行游戏主逻辑*/
        GameMain.run(nanos)
    }

}

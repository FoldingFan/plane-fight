package pers.chen.base

import javafx.scene.input.KeyEvent
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane

/**
 * @Author: chen
 * @Date: 2020/3/11 16:39
 * @VERSION 1.0
 *
 */
abstract class BaseView {
    val pane: Pane = StackPane()


    open fun onKeyPress(it: KeyEvent) {}

    /**
     * 进入时调用
     */
    open fun onEnter() {}

    /**
     * 视图更新
     */
    open fun onUpdate(nanos: Long) {}

    /**
     * 离开时调用
     */
    open fun onLeave() {}

    /**
     * 退出平台时调用
     */
    open fun onStop() {}
}

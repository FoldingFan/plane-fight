package pers.chen.base

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


    /**
     * 进入时调用
     */
    open fun onEnter() {}

    /**
     * 离开时调用
     */
    open fun onLeave() {}
}

package pers.chen.view

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import pers.chen.framwork.ViewManager

/**
 * @Author: chen
 * @Date: 2020/3/11 18:56
 * @VERSION 1.0
 *
 */
object HomeView : BaseView() {
    private val playBtn = Button("Play")
    private val exitBtn = Button("Exit")
    private val vBox = VBox(20.0, playBtn, exitBtn)

    init {
        playBtn.setOnAction { ViewManager.goView("game") }
        exitBtn.setOnAction { Platform.exit() }
        vBox.alignment = Pos.CENTER
        pane.children.add(vBox)
    }
}

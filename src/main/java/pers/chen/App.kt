package org.example

import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.text.TextAlignment
import javafx.stage.Stage
import java.io.File

/**
 * @Author: chen
 * @Date: 2020/3/11 12:15
 * @VERSION 1.0
 *
 */
class App : Application() {
    override fun start(stage: Stage) {
        stage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(App::class.java, * args)
}

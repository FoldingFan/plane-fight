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
    private val textField = TextField()
    private val button = Button("输出")
    private val label = Label()
    override fun start(stage: Stage) {
        label.textAlignment = TextAlignment.CENTER
        val vBox = VBox(20.0, textField, button, label)
        vBox.alignment = Pos.CENTER
        button.setOnAction {
            val file = File("./a.txt")
            if (!file.exists()) {
                file.createNewFile()
            }
            if (file.canWrite()) {
                file.writeText(textField.text)
                label.text = "输出成功，输出目录:${file.absolutePath}"
            } else {
                label.text = "文件不可用"
            }
        }
        val root = StackPane(vBox)
        stage.scene = Scene(root, 500.0, 500.0)
        stage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(App::class.java, * args)
}

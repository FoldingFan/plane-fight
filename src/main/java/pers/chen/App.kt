package pers.chen

import javafx.application.Application
import javafx.stage.Stage

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

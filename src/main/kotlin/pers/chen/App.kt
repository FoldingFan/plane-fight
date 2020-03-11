package pers.chen

import javafx.application.Application
import javafx.stage.Stage
import pers.chen.framwork.*
import pers.chen.view.GameView
import pers.chen.view.HomeView

/**
 * @Author: pers.chen
 * @Date: 2020/3/11 12:15
 * @VERSION 1.0
 *
 */
class App : Application() {
    override fun init() {
        regView("home", HomeView)
        regView("game", GameView)
        goView("home")
        GameCoroutines.play()
    }

    override fun start(stage: Stage) {
        stage.scene = viewRoot
        stage.show()
    }

    override fun stop() {
        viewMap.forEach { (_, view) -> view.onStop() }
    }
}

fun main(args: Array<String>) {
    Application.launch(App::class.java, * args)
}

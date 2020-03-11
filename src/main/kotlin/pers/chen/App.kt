package pers.chen

import javafx.application.Application
import javafx.stage.Stage
import pers.chen.game.GameCoroutines
import pers.chen.framwork.ViewManager
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
        ViewManager.regView("home", HomeView)
        ViewManager.regView("game", GameView)
        ViewManager.goView("home")
        GameCoroutines.play()
        ViewManager.viewRoot.setOnKeyPressed { ViewManager.currView?.onKeyPress(it) }
        ViewManager.viewRoot.setOnKeyReleased { ViewManager.currView?.onKeyRelease(it) }
    }

    override fun start(stage: Stage) {
        stage.scene = ViewManager.viewRoot
        stage.show()
    }

    override fun stop() {
        ViewManager.viewMap.forEach { (_, view) -> view.onStop() }
    }
}

fun main(args: Array<String>) {
    Application.launch(App::class.java, * args)
}

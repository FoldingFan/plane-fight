package pers.chen

import javafx.application.Application
import javafx.stage.Stage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pers.chen.audio.Boom
import pers.chen.audio.Fire

/**
 * @Author: pers.chen
 * @Date: 2020/3/11 12:15
 * @VERSION 1.0
 *
 */
class App : Application() {
    override fun start(stage: Stage) {
        GlobalScope.launch {
            Boom.play()
            delay(1000)
            Fire.play()
        }
        stage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(App::class.java, * args)
}

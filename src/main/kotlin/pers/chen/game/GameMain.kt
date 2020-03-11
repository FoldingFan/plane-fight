package pers.chen.game

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import pers.chen.game.base.GameObj
import pers.chen.game.entity.HeroFly

/**
 * @Author: chen
 * @Date: 2020/3/11 20:57
 * @VERSION 1.0
 *
 */

private val gameObjList = HashSet<GameObj>()

/*游戏画板*/
val canvas = Canvas(500.0, 500.0)
val graphics: GraphicsContext = canvas.graphicsContext2D

object GameMain {

    init {
        gameObjList.add(HeroFly)
    }

    fun run(nano: Long) {
        graphics.fill = Color.web("#000000")
        graphics.fillRect(0.0, 0.0, 500.0, 500.0)
        gameObjList.forEach {
            graphics.drawImage(it.image, it.posX, it.posY, it.width, it.height)
        }
    }
}

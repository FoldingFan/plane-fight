package pers.chen.game

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import pers.chen.game.beans.AbstractGameObject
import pers.chen.game.beans.AbstractMoveObject
import pers.chen.game.beans.HeroFly

/**
 * @Author: chen
 * @Date: 2020/3/11 20:57
 * @VERSION 1.0
 *
 */
object GameMain {
    private val gameObjList = HashSet<AbstractGameObject>()

    /*游戏画板*/
    val canvas = Canvas(500.0, 500.0)
    private val graphics: GraphicsContext = canvas.graphicsContext2D

    init {
        gameObjList.add(HeroFly)
    }

    /**
     * 每帧调用
     */
    fun run(nano: Long) {
        graphics.fill = Color.web("#000000")
        graphics.fillRect(0.0, 0.0, 500.0, 500.0)
        gameObjList.forEach {
            it.update(nano)
            it.draw(graphics)
            it.move()
        }
    }


}

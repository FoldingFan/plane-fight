package pers.chen.game

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import pers.chen.framwork.GAME_HEIGHT
import pers.chen.framwork.GAME_WIDHT
import pers.chen.game.beans.AbstractGameObject
import pers.chen.game.beans.HeroFly
import java.util.concurrent.CopyOnWriteArraySet

/**
 * @Author: chen
 * @Date: 2020/3/11 20:57
 * @VERSION 1.0
 * 游戏管理
 */
object GameManager {
    /*线程安全的set*/
    private val gameObjList = CopyOnWriteArraySet<AbstractGameObject>()

    /*游戏画板*/
    val canvas = Canvas(GAME_WIDHT, GAME_HEIGHT)
    private val graphics: GraphicsContext = canvas.graphicsContext2D

    init {
        gameObjList.add(HeroFly)
    }


    fun addObj(obj: AbstractGameObject) {
        gameObjList.add(obj)
    }

    fun removeObj(obj: AbstractGameObject) {
        gameObjList.remove(obj)
    }

    /**
     * 每帧调用
     */
    fun run(nano: Long) {
        graphics.fill = Color.web("#000000")
        graphics.fillRect(0.0, 0.0, GAME_WIDHT, GAME_HEIGHT)
        gameObjList.forEach {
            it.move()
            it.update(nano)
            it.draw(graphics)
        }
    }


}

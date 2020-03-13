package pers.chen.game

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import pers.chen.framwork.GAME_HEIGHT
import pers.chen.framwork.GAME_WIDHT
import pers.chen.framwork.MainThread
import pers.chen.game.beans.AbstractGameObject
import pers.chen.game.beans.HeroPlane
import pers.chen.game.beans.enemy.Enemy1

/**
 * @Author: chen
 * @Date: 2020/3/11 20:57
 * @VERSION 1.0
 * 游戏管理
 */
object GameManager {
    /*游戏对象集合*/
    private val gameObjList = hashSetOf<AbstractGameObject>()

    /*待删除游戏对象*/
    private val gameObjListRemove = hashSetOf<AbstractGameObject>()

    /*待添加游戏对象*/
    private val gameObjListAdd = hashSetOf<AbstractGameObject>()

    /*敌机数量*/
    private var enemyCount = 0

    /*游戏画板*/
    val canvas = Canvas(GAME_WIDHT, GAME_HEIGHT)
    private val graphics: GraphicsContext = canvas.graphicsContext2D

    private const val totalEnemyCount = 5

    init {
        gameObjList.add(HeroPlane)
    }


    fun addObj(obj: AbstractGameObject) {
        gameObjListAdd.add(obj)
    }

    fun removeObj(obj: AbstractGameObject) {
        gameObjListRemove.remove(obj)
    }

    /**
     * 每帧调用
     */
    fun run(useNano: Long) {
        graphics.fill =
                Color.BLACK
        graphics.fillRect(0.0, 0.0, GAME_WIDHT, GAME_HEIGHT)
        graphics.fill = Color.WHITE
        graphics.fillText("FPS:${MainThread.realFps}", 10.0, 20.0)
        createEnemy()
        gameObjList.forEach {
            it.update(useNano)
            it.move(useNano)
            it.draw(graphics)
        }
        gameObjList.addAll(gameObjListAdd)
        gameObjList.removeAll(gameObjListRemove)
    }


    /*创建敌机*/
    private fun createEnemy() {
        if (enemyCount < totalEnemyCount) {
            addObj(Enemy1())
            enemyCount++
        }
    }

}

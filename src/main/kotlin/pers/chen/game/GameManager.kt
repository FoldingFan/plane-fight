package pers.chen.game

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import pers.chen.framwork.GAME_HEIGHT
import pers.chen.framwork.GAME_WIDHT
import pers.chen.framwork.MainThread
import pers.chen.game.beans.AbstractGameObject
import pers.chen.game.beans.HeroPlane
import pers.chen.game.beans.enemy.AbstractEnemy
import pers.chen.game.beans.enemy.Enemy
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * @Author: chen
 * @Date: 2020/3/11 20:57
 * @VERSION 1.0
 * 游戏管理
 */
object GameManager {
    /*游戏对象集合*/
    private val gameObjList = arrayListOf<AbstractGameObject>()

    /*待删除游戏对象*/
    private val gameObjListRemove = arrayListOf<AbstractGameObject>()

    /*待添加游戏对象*/
    private val gameObjListAdd = arrayListOf<AbstractGameObject>()


    /*游戏画板*/
    val canvas = Canvas(GAME_WIDHT, GAME_HEIGHT)
    private val graphics: GraphicsContext = canvas.graphicsContext2D

    /*当前敌机数量*/
    private var enemyCount = 0

    /*最大敌机数量*/
    private const val totalEnemyCount = 5

    init {
        gameObjList.add(HeroPlane)
    }


    fun addObj(obj: AbstractGameObject) {
        gameObjListAdd.add(obj)
    }

    fun removeObj(obj: AbstractGameObject) {
        gameObjListRemove.add(obj)
        if (obj is AbstractEnemy) {
            enemyCount--
        }
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
            /*显示碰撞体积*/
//            graphics.stroke = Color.GREEN
//            graphics.strokeOval(it.posInfo.centerX - it.hitWidth / 2, it.posInfo.centerY - it.hitWidth / 2, it.hitWidth, it.hitWidth)
        }
        collisionDistance()
        gameObjList.addAll(gameObjListAdd)
        gameObjListAdd.clear()
        gameObjList.removeAll(gameObjListRemove)
        gameObjListRemove.clear()
    }

    /*碰撞检测*/
    private fun collisionDistance() {
        for (i in gameObjList.indices) {
            val one = gameObjList[i]
            for (j in i until gameObjList.size) {
                val two = gameObjList[j]
                val collisionDistance = one.hitWidth / 2 + two.hitWidth / 2
                val b1 = abs(one.posInfo.centerX - two.posInfo.centerX)
                val b2 = abs(one.posInfo.centerY - two.posInfo.centerY)
                val realDistance = sqrt(b1 * b1 + b2 * b2)
                if (collisionDistance > realDistance && one != two) {
                    one.collision(two)
                    two.collision(one)
                }
            }
        }
    }

    /*创建敌机*/
    private fun createEnemy() {
        if (enemyCount < totalEnemyCount) {
            addObj(Enemy())
            enemyCount++
        }
    }

}

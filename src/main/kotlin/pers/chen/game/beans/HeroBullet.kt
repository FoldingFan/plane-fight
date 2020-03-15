package pers.chen.game.beans

import pers.chen.framwork.GAME_WIDHT
import pers.chen.game.GameManager
import pers.chen.game.beans.enemy.AbstractEnemy

/**
 * @Author: chen
 * @Date: 2020/3/12 10:27
 * @VERSION 1.0
 *
 */
class HeroBullet : AbstractBullet() {
    init {
        posInfo.width = 5.0
        posInfo.height = 20.0
        hitWidth = 5.0
        speed = 360.0
    }

    override fun collision(gameObject: AbstractGameObject) {
        when (gameObject) {
            is AbstractEnemy -> {
                GameManager.removeObj(this)
            }
        }
    }


    override fun update(nano: Long) {
        /*出去就删除自己*/
        if (posInfo.centerX <= -100 || posInfo.centerX >= GAME_WIDHT + 100
                || posInfo.centerY <= -100 || posInfo.centerY >= GAME_WIDHT + 100) {
            GameManager.removeObj(this)
        }
    }


}



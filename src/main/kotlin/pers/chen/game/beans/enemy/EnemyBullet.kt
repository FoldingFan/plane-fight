package pers.chen.game.beans.enemy

import pers.chen.framwork.GAME_WIDHT
import pers.chen.game.GameManager
import pers.chen.game.beans.AbstractBullet
import pers.chen.game.beans.AbstractGameObject
import pers.chen.game.beans.HeroPlane

/**
 * @Author: chen
 * @Date: 2020/3/15 23:40
 * @VERSION 1.0
 * 敌人子弹
 */
class EnemyBullet : AbstractBullet() {
    init {
        posInfo.width = 2.0
        posInfo.height = 10.0
        hitWidth = 5.0
        speed = 120.0
    }

    override fun collision(gameObject: AbstractGameObject) {
        when (gameObject) {
            is HeroPlane -> {
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

package pers.chen.game.beans.enemy

import pers.chen.audio.BoomAudio
import pers.chen.audio.FireAudio
import pers.chen.framwork.GAME_WIDHT
import pers.chen.game.GameManager
import pers.chen.game.beans.AbstractGameObject
import pers.chen.game.beans.HeroBullet
import pers.chen.game.beans.HeroPlane
import pers.chen.game.beans.createBullet
import pers.chen.util.getDirect
import pers.chen.util.getImage


/**
 * @Author: chen
 * @Date: 2020/3/13 11:26
 * @VERSION 1.0
 *
 */
class Enemy : AbstractEnemy() {
    private var life = 10

    init {
        posInfo.width = 100.0
        posInfo.height = 116.0
        hitWidth = 60.0
        posInfo.centerX = Math.random() * (GAME_WIDHT + 100) - 50
        posInfo.centerY = Math.random() * -100 - 116
        bulletOnSec = 1.0
        speed = 60.0
        image = getImage("./images/hero.png")
    }

    override fun fire() {
        createBullet(posInfo.centerX, posInfo.centerY, posInfo.direct, false)
        FireAudio.play()
    }

    override fun collision(gameObject: AbstractGameObject) {
        when (gameObject) {
            is HeroPlane -> println("撞到英雄")
            is HeroBullet -> {
                if (--life == 0) {
                    GameManager.removeObj(this)
                    BoomAudio.play()
                }
            }
        }
    }

    override fun update(useNano: Long) {
        isFire(useNano)
        posInfo.direct = getDirect(posInfo, HeroPlane.posInfo)
    }
}

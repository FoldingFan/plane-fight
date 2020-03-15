package pers.chen.game.beans

import pers.chen.audio.BoomAudio
import pers.chen.audio.FireAudio
import pers.chen.framwork.GAME_HEIGHT
import pers.chen.framwork.GAME_WIDHT
import pers.chen.game.KeyPress
import pers.chen.game.beans.enemy.EnemyBullet
import pers.chen.util.getImage
import pers.chen.game.beans.enemy.AbstractEnemy as AbstractEnemy1

/**
 * @Author: chen
 * @Date: 2020/3/11 21:04
 * @VERSION 1.0
 * 英雄飞机
 */
object HeroPlane : AbstractPlaneObject() {
    private const val fireRange = 10

    init {
        posInfo.width = 69.0
        posInfo.height = 51.0
        this.posInfo.centerX = GAME_WIDHT / 2
        this.posInfo.centerY = GAME_HEIGHT / 2
        hitWidth = 10.0
        bulletOnSec = 15.0
        image = getImage("./images/hero.png")
    }

    /**
     * 按键更新，当方向键变更时触发
     */
    fun updateDirect() {
        if (KeyPress.up) posInfo.direct = 0.0
        if (KeyPress.down) posInfo.direct = Math.PI
        if (KeyPress.left) posInfo.direct = Math.PI / 2 + Math.PI
        if (KeyPress.right) posInfo.direct = Math.PI / 2
        if (KeyPress.up && KeyPress.left) posInfo.direct = Math.PI * 2 - Math.PI / 4
        if (KeyPress.up && KeyPress.right) posInfo.direct = Math.PI / 4
        if (KeyPress.down && KeyPress.left) posInfo.direct = Math.PI + Math.PI / 4
        if (KeyPress.down && KeyPress.right) posInfo.direct = Math.PI - Math.PI / 4
    }

    override fun fire() {
        createBullet(posInfo.centerX + (Math.random() * fireRange - fireRange / 2), posInfo.centerY, true)
        FireAudio.play()
    }

    override fun collision(gameObject: AbstractGameObject) {
        if (gameObject is AbstractEnemy1 || gameObject is EnemyBullet) {
            this.posInfo.centerX = GAME_WIDHT / 2
            this.posInfo.centerY = GAME_HEIGHT / 2
            BoomAudio.play()
        }
    }

    override fun update(useNano: Long) {
        /*开火*/
        if (KeyPress.fire) super.isFire(useNano)
        /*方向*/
        if (!KeyPress.right && !KeyPress.left && !KeyPress.up && !KeyPress.down) {
            if (speed > 0.0) {
                speed -= speed / 10
                speed = if (speed.compareTo(10) < 0) 0.0 else speed
            }
        } else if (speed < 180) {
            speed += (180 - speed) / 10
            speed = if (speed >= 170.0) 180.0 else speed
        }
        posInfo.posX = if (posInfo.posX <= 0) 0.0 else posInfo.posX
        posInfo.posY = if (posInfo.posY <= 0) 0.0 else posInfo.posY

        posInfo.posX = if (posInfo.posX >= GAME_WIDHT - posInfo.width) GAME_WIDHT - posInfo.width else posInfo.posX
        posInfo.posY = if (posInfo.posY >= GAME_HEIGHT - posInfo.height) GAME_HEIGHT - posInfo.height else posInfo.posY
    }
}

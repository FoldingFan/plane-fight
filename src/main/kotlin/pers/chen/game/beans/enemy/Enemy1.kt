package pers.chen.game.beans.enemy

import javafx.geometry.Point3D
import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.ImageView
import javafx.scene.transform.Rotate
import pers.chen.audio.FireAudio
import pers.chen.framwork.GAME_WIDHT
import pers.chen.game.beans.AbstractPlaneObject
import pers.chen.game.beans.Bullet
import pers.chen.game.beans.HeroPlane
import pers.chen.util.getDirect
import pers.chen.util.getImage
import java.lang.System.gc


/**
 * @Author: chen
 * @Date: 2020/3/13 11:26
 * @VERSION 1.0
 *
 */
class Enemy1 : AbstractPlaneObject() {
    init {
        posInfo.width = 100.0
        posInfo.height = 116.0
        posInfo.centerX = Math.random() * (GAME_WIDHT + 100) - 50
        posInfo.centerY = Math.random() * -100 - 116
        bulletOnSec = 1.0
        speed = 60.0
        image = getImage("./images/hero.png")
    }

    override fun fire() {
        Bullet.createBullet(posInfo.centerX, posInfo.centerY, posInfo.direct, false)
        FireAudio.play()
    }

    override fun update(useNano: Long) {
        isFire(useNano)
        val s = Math.random() * 0.6 - 0.3
        posInfo.direct = getDirect(posInfo, HeroPlane.posInfo) + s
    }
}

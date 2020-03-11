package pers.chen.game.entity

import javafx.scene.image.Image
import pers.chen.game.GameKeyHandler
import pers.chen.game.base.GameObj
import java.io.File
import java.io.FileInputStream

/**
 * @Author: chen
 * @Date: 2020/3/11 21:04
 * @VERSION 1.0
 *
 */
object HeroFly : GameObj() {
    init {
        width = 50.0
        height = 58.0
        centerX = 250.0
        centerY = 250.0
        image = Image(FileInputStream(File("./images/hero.png")))
    }

    override fun update(nano: Long) {
        if (GameKeyHandler.left) {
            direct = Math.PI
        }
    }
}

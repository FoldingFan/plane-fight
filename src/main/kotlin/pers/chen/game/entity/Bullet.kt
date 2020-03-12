package pers.chen.game.entity

import javafx.scene.canvas.GraphicsContext
import pers.chen.util.getImage

/**
 * @Author: chen
 * @Date: 2020/3/12 10:27
 * @VERSION 1.0
 *
 */
class Bullet : MoveObj() {
    init {
        posInfo.width = 5.0
        posInfo.height = 5.0
        image = getImage("./images/bullet_hero.png")
    }

    override fun draw(g: GraphicsContext) {
        g.drawImage(image, posInfo.posX, posInfo.posY, posInfo.width, posInfo.height)
    }

    override fun update(nano: Long) {

    }

}

package pers.chen.game

import pers.chen.game.beans.HeroPlane

/**
 * @Author: chen
 * @Date: 2020/3/11 23:04
 * @VERSION 1.0
 * 标识按键状态
 */
object KeyPress {
    var left = false
        set(value) {
            if (field == value) return
            field = value
            if (right && field) right = !right
            HeroPlane.updateDirect()
        }
    var right = false
        set(value) {
            if (field == value) return
            field = value
            if (left && field) left = !left
            HeroPlane.updateDirect()
        }
    var up = false
        set(value) {
            if (field == value) return
            field = value
            if (down && field) down = !down
            HeroPlane.updateDirect()
        }
    var down = false
        set(value) {
            if (field == value) return
            field = value
            if (up && field) up = !up
            HeroPlane.updateDirect()
        }
    var fire = false
}

package pers.chen.game

import pers.chen.game.entity.HeroFly

/**
 * @Author: chen
 * @Date: 2020/3/11 23:04
 * @VERSION 1.0
 *
 */
object KeyPress {
    var left = false
        set(value) {
            if (field == value) return
            field = value
            if (right && field) right = !right
            HeroFly.updateDirect()
        }
    var right = false
        set(value) {
            if (field == value) return
            field = value
            if (left && field) left = !left
            HeroFly.updateDirect()
        }
    var up = false
        set(value) {
            if (field == value) return
            field = value
            if (down && field) down = !down
            HeroFly.updateDirect()
        }
    var down = false
        set(value) {
            if (field == value) return
            field = value
            if (up && field) up = !up
            HeroFly.updateDirect()
        }
}

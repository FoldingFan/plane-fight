package pers.chen.game

import pers.chen.game.entity.HeroFly

/**
 * @Author: chen
 * @Date: 2020/3/11 21:56
 * @VERSION 1.0
 *
 */
object GameLogic {
    fun left() {
        HeroFly.centerX = HeroFly.centerX - 1
    }

    fun up() {
        HeroFly.centerY = HeroFly.centerY - 1
    }

    fun right() {
        HeroFly.centerX = HeroFly.centerX + 1
    }

    fun down() {
        HeroFly.centerY = HeroFly.centerY + 1
    }
}

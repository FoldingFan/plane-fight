package pers.chen.util

import pers.chen.game.beans.PosInfo
import kotlin.math.atan2

/**
 * @Author: chen
 * @Date: 2020/3/13 11:39
 * @VERSION 1.0
 *
 */
fun getDirect(posInfo1: PosInfo, posInfo2: PosInfo): Double {
    val x = posInfo2.centerX - posInfo1.centerX
    val y = posInfo1.centerY - posInfo2.centerY
    return atan2(x, y)
}

package pers.chen.util

import javafx.scene.image.Image
import java.io.File
import java.io.FileInputStream

/**
 * @Author: chen
 * @Date: 2020/3/11 22:25
 * @VERSION 1.0
 *
 */

fun getImage(path: String): Image? {
    val file = File(path)
    if (file.exists()) {
        return Image(FileInputStream(file))
    }
    return null
}

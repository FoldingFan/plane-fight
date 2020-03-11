package pers.chen.audio

import javafx.scene.media.AudioClip
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import java.io.File

/**
 * @Author: chen
 * @Date: 2020/3/11 18:00
 * @VERSION 1.0
 *
 */
private val baseAudio = File("./audio/").toURI().toString()
private val boom = "${baseAudio}boom.mp3"

sealed class Audio(private val path: String) {

    fun play() {
        AudioClip(boom).play()
    }
}

object Boom : Audio(boom)
object Fire : Audio(boom)


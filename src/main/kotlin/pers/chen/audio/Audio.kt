package pers.chen.audio

import javafx.scene.media.AudioClip
import java.io.File

/**
 * @Author: chen
 * @Date: 2020/3/11 18:00
 * @VERSION 1.0
 *
 */
private val baseAudio = File("./audio/").toURI().toString()
private val boom = "${baseAudio}boom.mp3"
private val fire = "${baseAudio}fire.mp3"

sealed class Audio(private val path: String) {
    private val audioClip: AudioClip = AudioClip(path)
    fun play() {
        audioClip.play()
    }
}

object BoomAudio : Audio(boom)
object FireAudio : Audio(fire)

fun main() {
    BoomAudio.play()
    Thread.sleep(5000)
}

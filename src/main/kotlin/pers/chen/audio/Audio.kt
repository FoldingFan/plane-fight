package pers.chen.audio

import javafx.scene.media.AudioClip
import java.io.File

/**
 * @Author: chen
 * @Date: 2020/3/11 18:00
 * @VERSION 1.0
 *
 */
private val boom = File("./audio/boom.mp3")
private val fire = File("./audio/fire.mp3")

sealed class Audio(private val audioFile: File) {
    private var audioClip: AudioClip? = null

    init {
        /*检查音乐是否存在*/
        if (audioFile.exists()) {
            audioClip = AudioClip(audioFile.toURI().toString())
        }
    }

    fun play() {
        audioClip?.play()
    }
}

object BoomAudio : Audio(boom)
object FireAudio : Audio(fire)

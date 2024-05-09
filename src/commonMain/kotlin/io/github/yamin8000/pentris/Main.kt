package io.github.yamin8000.pentris

import io.github.yamin8000.pentris.util.*
import korlibs.time.*
import korlibs.korge.*
import korlibs.korge.scene.*
import korlibs.korge.tween.*
import korlibs.korge.view.*
import korlibs.image.format.*
import korlibs.io.file.std.*
import korlibs.korge.time.*
import korlibs.math.geom.*
import korlibs.math.interpolation.*
import kotlin.time.*

suspend fun main() = Korge(
    backgroundColor = Constants.BACKGROUND
) {
    val sceneContainer = sceneContainer()

    sceneContainer.changeTo { Splash() }
    delay(Duration.fromSeconds(3))
    sceneContainer.changeTo { MyScene() }
}

class MyScene : Scene() {
    override suspend fun SContainer.sceneMain() {
        val minDegrees = (-32).degrees
        val maxDegrees = (+16).degrees

        val image = image(resourcesVfs["korge.png"].readBitmap()) {
            rotation = maxDegrees
            anchor(.5, .5)
            scale(0.8)
            position(256, 256)
        }

        while (true) {
            image.tween(image::rotation[minDegrees], time = 1.seconds, easing = Easing.EASE_IN_OUT)
            image.tween(image::rotation[maxDegrees], time = 1.seconds, easing = Easing.EASE_IN_OUT)
        }
    }
}

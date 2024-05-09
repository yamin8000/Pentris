package io.github.yamin8000.pentris

import io.github.yamin8000.pentris.util.*
import korlibs.image.text.*
import korlibs.korge.scene.*
import korlibs.korge.view.*

class Splash : Scene() {

    override suspend fun SContainer.sceneMain() {
        println(size.toString())
        solidRect(size, Constants.BACKGROUND)
        text(
            text = "Hello there!",
            alignment = TextAlignment.MIDDLE_CENTER,
            block = {
                positionX(size.width / 2)
                positionY(size.height / 2)
            }
        )
    }
}

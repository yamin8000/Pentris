import korlibs.korge.gradle.*

plugins {
    alias(libs.plugins.korge)
}

korge {
    id = "io.github.yamin8000.pentris"
    version = "1.0.0"
    exeBaseName = "Pentris"
    name = "Pentris"
    description = "Tetris but with 5-cell blocks"
    orientation = Orientation.DEFAULT
    copyright = "Copyright (c) 2024 Yamin Siahmargooei"

    authorName = "Yamin Siahmargooei"
    authorEmail = "me@yamins.ir"
    authorHref = "https://yamins.ir"

    gameCategory = GameCategory.PUZZLE
    fullscreen = true

    backgroundColor = 0xff000000.toInt()

    entryPoint = "io.github.yamin8000.pentris.main"
    jvmMainClassName = "io.github.yamin8000.pentris.MainKt"
    androidMinSdk = 24
    androidTargetSdk = 34

// To enable all targets at once

    //targetAll()

// To enable targets based on properties/environment variables
    //targetDefault()

// To selectively enable targets

    targetJvm()
    //targetJs()
    //targetWasm()
    //targetDesktop()
    //targetIos()
    targetAndroid()

    serializationJson()
}

/*tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "io.github.yamin8000.pentris.MainKt"
    }
}*/

dependencies {
    add("commonMainApi", project(":deps"))
    //add("commonMainApi", project(":korge-dragonbones"))
}


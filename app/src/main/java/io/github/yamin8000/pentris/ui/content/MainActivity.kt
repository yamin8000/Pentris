/*
 *     Pentris/Pentris.app.main
 *     MainActivity.kt Copyrighted by Yamin Siahmargooei at 2024/5/10
 *     MainActivity.kt Last modified at 2024/5/9
 *     This file is part of Pentris/Pentris.app.main.
 *     Copyright (C) 2024  Yamin Siahmargooei
 *
 *     Pentris/Pentris.app.main is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Pentris/Pentris.app.main is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Pentris.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.yamin8000.pentris.ui.content

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.github.yamin8000.pentris.ui.theme.PentrisTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            PentrisTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { innerPadding ->
                        Board(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Board(
    modifier: Modifier = Modifier,
    speed: Long = 500L,
    color: Color = randomColor(),
    onPlaced: (Float, Float) -> Unit = { _, _ -> }
) {
    var isPlaced by remember { mutableStateOf(false) }

    val width = LocalConfiguration.current.screenWidthDp.dp
    val widthPx = with(LocalDensity.current) { width.toPx() }
    val height = LocalConfiguration.current.screenHeightDp.dp
    val heightPx = with(LocalDensity.current) { height.toPx() } - 50f

    val cellSize = (width.value / 5f).toInt()
    val center = with(LocalDensity.current) {
        (width.toPx() / 2) - cellSize
    }

    var y by remember { mutableFloatStateOf(-cellSize.toFloat()) }

    var x by remember { mutableFloatStateOf(center) }

    var pointer by remember { mutableStateOf(Offset(-1f, -1f)) }

    LaunchedEffect(Unit) {
        while (true) {
            if (y >= heightPx - cellSize) {
                isPlaced = true
                onPlaced(x, y)
                break
            }
            y += cellSize
            delay(speed)
        }
    }

    /*Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        content = {
            repeat((heightPx / cellSize).toInt()) {
                Row(
                    content = {
                        repeat((widthPx / cellSize).toInt()) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RectangleShape)
                                    .background(randomColor())
                            )
                        }
                    }
                )
            }
        }
    )*/
        Canvas(
            modifier = modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    this.awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            pointer = event.changes.first().position

                            if (!isPlaced) {
                                if (pointer.x > x) {
                                    x += cellSize
                                } else {
                                    x -= cellSize
                                }
                            }
                            runBlocking { delay(50) }
                        }
                    }
                },
            onDraw = {
                drawCircle(
                    color = Color.Red,
                    center = pointer,
                    radius = 10f
                )

                drawRoundRect(
                    color = color,
                    topLeft = Offset(x, y),
                    size = Size(
                        cellSize.toFloat(),
                        cellSize.toFloat()
                    ),
                )
            }
        )
}

private fun randomColor(): Color {
    val red = (0..255).random()
    val green = (0..255).random()
    val blue = (0..255).random()
    return Color(red, green, blue)
}
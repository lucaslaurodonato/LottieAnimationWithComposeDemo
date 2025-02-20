package com.example.lottieanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dotlottie.dlplayer.Mode
import com.example.lottieanimation.ui.theme.LottieAnimationTheme
import com.example.lottieanimation.ui.DsButton
import com.example.lottieanimation.ui.DsText
import com.example.lottieanimation.ui.LottieAnimation
import com.example.lottieanimation.utils.formatTimes
import com.lottiefiles.dotlottie.core.compose.runtime.DotLottieController

class MainActivity : ComponentActivity() {

    ///Max value defined
    private var maxValue: Float = 8f

    ///Speed initial
    private var speedAnimation: Float = 1f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent { ///To controller your animation
            val controller = remember { DotLottieController() }

            ///Text to controller speed
            var text by remember { mutableStateOf("1x") }

            LottieAnimationTheme {
                Box(
                    modifier = Modifier
                        .statusBarsPadding()
                        .navigationBarsPadding()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(
                                rememberScrollState()
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        DsText(stringResource(R.string.lottie_animation))
                        LottieAnimation(controller)
                        Row(
                            modifier = Modifier.padding(top = 32.dp)
                        ) {
                            DsButton(
                                onClick = {
                                    if (controller.isPlaying) {
                                        controller.pause()
                                    } else {
                                        controller.play()
                                    }
                                },
                                text = "Play/Pause",
                                icon = Icons.Default.PlayArrow,
                            )
                            DsButton(
                                onClick = {
                                    text = changeValueSpeed()
                                    controller.setSpeed(speedAnimation)
                                },
                                text = text,
                            )
                        }
                        DsButton(
                            onClick = {
                                controller.stop()
                            },
                            text = "Finish",
                        )
                    }
                }
            }
        }
    }

    ///Fun that return and set speed animation
    private fun changeValueSpeed(): String {
        if (speedAnimation < maxValue) {
            ///Add 1 when click
            speedAnimation++
        } else {
            ///When it reaches the maximum value it will reset
            speedAnimation = 1f
        }
        ///Return formated text to the button
        return getString(R.string.how_many_times, formatTimes(speedAnimation))
    }
}
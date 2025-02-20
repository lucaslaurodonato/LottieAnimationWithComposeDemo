package com.example.lottieanimation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dotlottie.dlplayer.Mode
import com.lottiefiles.dotlottie.core.compose.runtime.DotLottieController
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource

@Composable
internal fun LottieAnimation(controller: DotLottieController) {
    DotLottieAnimation(
        source = DotLottieSource.Asset("rocket.json"),
        loop = true,
        autoplay = true,
        playMode = Mode.FORWARD,
        modifier = Modifier.padding(top = 64.dp),
        controller = controller,
    )
}
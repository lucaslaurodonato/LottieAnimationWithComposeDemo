package com.example.lottieanimation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lottieanimation.R

@Composable
internal fun DsText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        color = Color.Black,
        modifier = Modifier.padding(top = 36.dp),
    )
}

@Preview
@Composable
private fun EmptyScreenPreview() {
    DsText(stringResource(R.string.lottie_animation))
}
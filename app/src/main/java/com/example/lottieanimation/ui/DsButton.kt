package com.example.lottieanimation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun DsButton(
    onClick: () -> Unit,
    text: String? = null,
    icon: ImageVector? = null,
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        enabled = true,
        contentPadding = PaddingValues(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
    ) {
        icon?.let {
            Image(
                imageVector = it,
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        text?.let {
            Text(text = it)
        }
    }
}

@Preview
@Composable
private fun EmptyScreenPreview() {
    DsButton(
        onClick = {}, text = "Teste de botão"
    )
}
package me.adrianalvarez.facebook.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable que representa el botón de "Me gusta" de una publicación de Facebook.
 *
 * Es un composable sin estado (stateless) que organiza:
 * - Icono de la manita (pulgar arriba).
 * - Texto "Me gusta" a la derecha del icono.
 *
 * @param isLiked Indica si la publicación tiene el "Me gusta" activado.
 * @param onClick Callback que se ejecuta al presionar el botón.
 * @param modifier Modificador para personalizar el layout.
 * @param text Texto a mostrar al lado del icono, por defecto "Me gusta".
 */
@Composable
fun LikeButton(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onClick: () -> Unit = {},
    text: String = "Me gusta"
) {
    val icon: ImageVector = if (isLiked) Icons.Filled.ThumbUp else Icons.Outlined.ThumbUp
    val contentColor: Color = if (isLiked) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = contentColor,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = text,
            color = contentColor,
            fontSize = 14.sp,
            fontWeight = if (isLiked) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LikeButtonPreview() {
    Row {
        LikeButton(isLiked = false)
        Spacer(modifier = Modifier.width(16.dp))
        LikeButton(isLiked = true)
    }
}

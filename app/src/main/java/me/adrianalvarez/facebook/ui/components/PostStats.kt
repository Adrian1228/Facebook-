package me.adrianalvarez.facebook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable que muestra las estadísticas de interacción de una publicación de Facebook.
 *
 * Es un composable sin estado (stateless) que muestra:
 * - A la izquierda: La figura del "Me gusta" (icono en un círculo azul) y la cantidad de likes.
 * - A la derecha: La cantidad de comentarios con el texto "comentarios".
 *
 * @param modifier Modificador para personalizar el layout.
 * @param likesCount Número de likes de la publicación.
 * @param commentsCount Número de comentarios de la publicación.
 * @param onLikesClick Callback al hacer clic en el área de likes.
 * @param onCommentsClick Callback al hacer clic en el área de comentarios.
 */
@Composable
fun PostStats(
    modifier: Modifier = Modifier,
    likesCount: Int = 0,
    commentsCount: Int = 0,
    onLikesClick: () -> Unit = {},
    onCommentsClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Lado izquierdo: Icono de Like y cantidad de likes
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = onLikesClick),
        ) {
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = "Likes",
                    tint = Color.White,
                    modifier = Modifier.size(11.dp),
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "$likesCount",
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        // Lado derecho: Cantidad de comentarios y el texto "comentarios"
        Text(
            text = "$commentsCount comentarios",
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.clickable(onClick = onCommentsClick),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostStatsPreview() {
    PostStats(
        likesCount = 124,
        commentsCount = 45,
    )
}

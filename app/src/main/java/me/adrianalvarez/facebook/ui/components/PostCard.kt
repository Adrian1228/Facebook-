package me.adrianalvarez.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Composable que representa la tarjeta completa de una publicación de Facebook.
 *
 * Incluye:
 * - Encabezado (PostHeader) con avatar, nombre y hora.
 * - Texto de la publicación.
 * - Imagen cargada desde internet con la librería Coil (`AsyncImage`).
 * - Estadísticas (PostStats) con número de likes y comentarios.
 * - Botones de interacción (PostActions) de Me gusta, Comentar y Compartir.
 */
@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    userName: String = "Adrian Alvarez",
    postTime: String = "Hace 15 min",
    postText: String = "Por fin terminé la pantalla de Login",
    imageUrl: String? = "https://picsum.photos/600/400",
    likesCount: Int = 124,
    commentsCount: Int = 45,
    isLiked: Boolean = false,
    onLikeClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        PostHeader(
            userName = userName,
            postTime = postTime,
        )

        Text(
            text = postText,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
        )

        if (!imageUrl.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = imageUrl,
                contentDescription = "Imagen de la publicación",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        PostStats(
            likesCount = likesCount,
            commentsCount = commentsCount,
        )

        PostActions(
            isLiked = isLiked,
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard()
}

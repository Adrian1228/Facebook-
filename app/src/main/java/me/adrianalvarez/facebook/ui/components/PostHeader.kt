package me.adrianalvarez.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable que simula el encabezado de una publicación de Facebook (PostHeader).
 *
 * Es un composable sin estado (stateless) que organiza:
 * - A la izquierda: Un icono de perfil (Avatar).
 * - Al centro (al lado del icono): Una columna con el nombre de usuario y el tiempo de activación / publicación.
 * - A la derecha: Un icono de 3 puntos para más opciones.
 *
 * @param userName Nombre del usuario que realiza la publicación.
 * @param postTime Tiempo transcurrido o de activación de la publicación.
 * @param modifier Modificador para personalizar el layout.
 * @param avatarIcon Icono del avatar de perfil.
 * @param onMoreOptionsClick Callback al hacer clic en el botón de 3 puntos.
 */
@Composable
fun PostHeader(
    userName: String,
    postTime: String,
    modifier: Modifier = Modifier,
    avatarIcon: ImageVector = Icons.Default.AccountCircle,
    onMoreOptionsClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono de perfil (Avatar) a la izquierda
        Icon(
            imageVector = avatarIcon,
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(10.dp))

        // Columna con Nombre y Hora de activación/publicación
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = userName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = postTime,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )
        }

        // Icono de 3 puntos a la derecha
        IconButton(onClick = onMoreOptionsClick) {
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "Opciones de la publicación"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostHeaderPreview() {
    PostHeader(
        userName = "Adrian Alvarez",
        postTime = "Hace 15 min"
    )
}

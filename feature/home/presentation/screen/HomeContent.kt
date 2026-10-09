package com.example.carteirinhadigital.feature.home.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.carteirinhadigital.R

@Composable
fun HomeContent(
    usuarioNome: String,
    onCarteirinhaClick: () -> Unit,
    onUnidadesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Seja Bem-vindo,",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = usuarioNome,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Image(
            painter = painterResource(R.drawable.logosenai),
            contentDescription = "Logo SENAI",
            modifier = Modifier.size(180.dp)
        )

        Spacer(Modifier.height(40.dp))

        Button(
            onClick = onCarteirinhaClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Abrir Carteirinha")
        }

        OutlinedButton(
            onClick = onUnidadesClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Unidades Curriculares")
        }
    }
}

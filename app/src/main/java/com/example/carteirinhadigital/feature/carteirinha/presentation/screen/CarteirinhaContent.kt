package com.example.carteirinhadigital.feature.carteirinha.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.carteirinhadigital.feature.carteirinha.presentation.CarteirinhaEvent
import com.example.carteirinhadigital.feature.carteirinha.presentation.CarteirinhaUiState
import com.example.carteirinhadigital.feature.carteirinha.presentation.component.InfoAluno
import com.example.carteirinhadigital.feature.carteirinha.presentation.component.PerfilAluno
import com.example.carteirinhadigital.feature.carteirinha.presentation.component.QrCode

@Composable
fun CarteirinhaContent(
    uiState: CarteirinhaUiState,
    onEvent: (CarteirinhaEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            uiState.isLoading -> CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            uiState.errorMessage != null -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(uiState.errorMessage, color = MaterialTheme.colorScheme.error)
                Button(onClick = { onEvent(CarteirinhaEvent.OnRetryClick) }) {
                    Text("Tentar novamente")
                }
            }
            uiState.carteirinha != null -> {
                val carteirinha = uiState.carteirinha
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    PerfilAluno()
                    Text(
                        text = carteirinha.nome,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    InfoAluno(carteirinha = carteirinha, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "QR Code de acesso",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    QrCode(
                        conteudo = carteirinha.qrCodeContent,
                        modifier = Modifier.size(180.dp)
                    )
                }
            }
        }
    }
}

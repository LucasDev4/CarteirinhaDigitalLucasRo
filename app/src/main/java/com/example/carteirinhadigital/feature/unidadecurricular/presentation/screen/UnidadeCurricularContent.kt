package com.example.carteirinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carteirinhadigital.feature.unidadecurricular.presentation.UnidadeCurricularEvent
import com.example.carteirinhadigital.feature.unidadecurricular.presentation.UnidadeCurricularUiState
import com.example.carteirinhadigital.feature.unidadecurricular.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularContent(
    uiState: UnidadeCurricularUiState,
    onEvent: (UnidadeCurricularEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            uiState.isLoading -> CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            uiState.errorMessage != null -> {
                androidx.compose.foundation.layout.Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(uiState.errorMessage, color = MaterialTheme.colorScheme.error)
                    Button(onClick = { onEvent(UnidadeCurricularEvent.OnRetryClick) }) {
                        Text("Tentar novamente")
                    }
                }
            }
            uiState.unidades.isEmpty() -> Text("Nenhuma unidade curricular encontrada.")
            else -> LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(uiState.unidades) { unidade ->
                    UnidadeCurricularCard(unidade = unidade)
                }
            }
        }
    }
}
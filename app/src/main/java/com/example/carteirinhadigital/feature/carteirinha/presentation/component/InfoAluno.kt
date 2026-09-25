package com.example.carteirinhadigital.feature.carteirinha.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carteirinhadigital.feature.carteirinha.domain.model.Carteirinha

@Composable
fun InfoAluno(carteirinha: Carteirinha, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            LabelText("Curso")
            ValueText(carteirinha.curso)
            Spacer(Modifier.height(8.dp))
            LabelText("Turma")
            ValueText(carteirinha.turma)
            Spacer(Modifier.height(8.dp))
            LabelText("Matrícula")
            ValueText(carteirinha.matricula)
            Spacer(Modifier.height(8.dp))
            LabelText("Unidade")
            ValueText(carteirinha.unidade)
            Spacer(Modifier.height(8.dp))
            LabelText("Status")
            ValueText(carteirinha.status)
        }
    }
}

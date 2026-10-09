
package com.example.carteirinhadigital.feature.carteirinha.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carteirinhadigital.feature.carteirinha.domain.model.Carteirinha

@Composable
fun InfoAluno(
    carteirinha: Carteirinha,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InfoCard {
            LabelText("Curso")
            Spacer(Modifier.height(4.dp))
            ValueText(carteirinha.curso)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InfoCard(
                modifier = Modifier.weight(1f)
            ) {
                LabelText("Turma")
                Spacer(Modifier.height(4.dp))
                ValueText(carteirinha.turma)
            }

            InfoCard(
                modifier = Modifier.weight(1f)
            ) {
                LabelText("Matrícula")
                Spacer(Modifier.height(4.dp))
                ValueText(carteirinha.matricula)
            }
        }

        InfoCard {
            LabelText("Unidade")
            Spacer(Modifier.height(4.dp))
            ValueText(carteirinha.unidade)

            Spacer(Modifier.height(12.dp))

            LabelText("Status")
            Spacer(Modifier.height(4.dp))
            ValueText(carteirinha.status)
        }
    }
}

@Composable
private fun InfoCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            content()
        }
    }
}

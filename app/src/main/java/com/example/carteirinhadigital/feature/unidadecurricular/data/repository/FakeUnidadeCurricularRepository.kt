package com.example.carteirinhadigital.feature.unidadecurricular.data.repository

import com.example.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular
import kotlinx.coroutines.delay

class FakeUnidadeCurricularRepository : UnidadeCurricularRepository {
    override suspend fun getUnidades(): List<UnidadeCurricular> {
        delay(1000)
        return listOf(
            UnidadeCurricular("1", "Mobile", 70, "Prof. Rafael Costa", "Em andamento"),
            UnidadeCurricular("2", "Banco de Dados", 76, "Prof. Roger", "Concluída"),
            UnidadeCurricular("3", "Desenvolvimento Web", 67, "Prof. Orrico", "Em andamento"),
            UnidadeCurricular("4", "Lógica de Programação", 24, "Prof. Rafael Oliveira", "Concluída"),
            UnidadeCurricular("5", "IOT", 42, "Prof. Lucas Felfoid", "Em andamento")
        )
    }
}
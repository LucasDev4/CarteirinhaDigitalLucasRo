package com.example.carteirinhadigital.feature.unidadecurricular.data.repository

import com.example.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun getUnidades(): List<UnidadeCurricular>
}
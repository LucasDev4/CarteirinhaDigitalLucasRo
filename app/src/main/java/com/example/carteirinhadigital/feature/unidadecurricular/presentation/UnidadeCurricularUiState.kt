package com.example.carteirinhadigital.feature.unidadecurricular.presentation

import com.example.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = true,
    val unidades: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)
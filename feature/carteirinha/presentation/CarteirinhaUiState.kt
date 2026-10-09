package com.example.carteirinhadigital.feature.carteirinha.presentation

import com.example.carteirinhadigital.feature.carteirinha.domain.model.Carteirinha

data class CarteirinhaUiState(
    val isLoading: Boolean = true,
    val carteirinha: Carteirinha? = null,
    val errorMessage: String? = null
)

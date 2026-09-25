package com.example.carteirinhadigital.feature.auth.presentation

import com.example.carteirinhadigital.feature.auth.domain.model.UsuarioLogado

data class LoginUiState(
    val usuario: String = "",
    val senha: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val usuarioLogado: UsuarioLogado? = null
)

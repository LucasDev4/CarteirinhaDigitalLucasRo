package com.example.carteirinhadigital.feature.auth.domain.model

data class UsuarioLogado(
    val id: String,
    val nome: String,
    val token: String
)

package com.example.carteirinhadigital.feature.carteirinha.domain.model

data class Carteirinha(
    val nome: String,
    val curso: String,
    val turma: String,
    val matricula: String,
    val unidade: String,
    val status: String,
    val qrCodeContent: String
)

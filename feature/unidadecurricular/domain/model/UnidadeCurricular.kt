package com.example.carteirinhadigital.feature.unidadecurricular.domain.model

data class UnidadeCurricular(
    val id: String,
    val nome: String,
    val cargaHoraria: Int,
    val professor: String,
    val status: String
)
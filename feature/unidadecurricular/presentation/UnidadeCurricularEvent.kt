package com.example.carteirinhadigital.feature.unidadecurricular.presentation

sealed class UnidadeCurricularEvent {
    data object OnRetryClick : UnidadeCurricularEvent()
}
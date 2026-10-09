package com.example.carteirinhadigital.feature.carteirinha.presentation

sealed class CarteirinhaEvent {
    data object OnRetryClick : CarteirinhaEvent()
}

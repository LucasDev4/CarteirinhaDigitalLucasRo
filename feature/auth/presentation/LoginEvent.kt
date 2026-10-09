package com.example.carteirinhadigital.feature.auth.presentation

sealed class LoginEvent {
    data class OnUsuarioChange(val value: String) : LoginEvent()
    data class OnSenhaChange(val value: String) : LoginEvent()
    data object OnLoginClick : LoginEvent()
}

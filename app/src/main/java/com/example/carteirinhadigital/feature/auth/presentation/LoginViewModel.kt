package com.example.carteirinhadigital.feature.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carteirinhadigital.feature.auth.data.repository.FakeAuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = FakeAuthRepository()

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnUsuarioChange -> _uiState.update { it.copy(usuario = event.value, errorMessage = null) }
            is LoginEvent.OnSenhaChange -> _uiState.update { it.copy(senha = event.value, errorMessage = null) }
            is LoginEvent.OnLoginClick -> login()
        }
    }

    private fun login() {
        val state = _uiState.value
        if (state.usuario.isBlank() || state.senha.isBlank()) {
            _uiState.update { it.copy(errorMessage = "Preencha usuário e senha.") }
            return
        }
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            val usuario = repository.login(state.usuario, state.senha)
            if (usuario != null) {
                _uiState.update { it.copy(isLoading = false, usuarioLogado = usuario) }
            } else {
                _uiState.update { it.copy(isLoading = false, errorMessage = "Usuário ou senha incorretos.") }
            }
        }
    }
}

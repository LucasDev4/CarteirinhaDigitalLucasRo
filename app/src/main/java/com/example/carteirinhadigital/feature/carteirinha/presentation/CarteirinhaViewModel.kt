package com.example.carteirinhadigital.feature.carteirinha.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carteirinhadigital.feature.carteirinha.data.repository.FakeCarteirinhaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CarteirinhaViewModel : ViewModel() {
    private val repository = FakeCarteirinhaRepository()

    private val _uiState = MutableStateFlow(CarteirinhaUiState())
    val uiState: StateFlow<CarteirinhaUiState> = _uiState

    init { carregarCarteirinha() }

    fun onEvent(event: CarteirinhaEvent) {
        when (event) {
            CarteirinhaEvent.OnRetryClick -> carregarCarteirinha()
        }
    }

    private fun carregarCarteirinha() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                val carteirinha = repository.getCarteirinha("001")
                _uiState.update {
                    if (carteirinha != null)
                        it.copy(isLoading = false, carteirinha = carteirinha)
                    else
                        it.copy(isLoading = false, errorMessage = "Carteirinha não encontrada.")
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, errorMessage = "Erro ao carregar carteirinha.") }
            }
        }
    }
}

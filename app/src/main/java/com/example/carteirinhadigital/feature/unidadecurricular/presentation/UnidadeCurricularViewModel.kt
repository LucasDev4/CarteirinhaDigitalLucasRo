package com.example.carteirinhadigital.feature.unidadecurricular.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carteirinhadigital.feature.unidadecurricular.data.repository.FakeUnidadeCurricularRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UnidadeCurricularViewModel : ViewModel() {

    private val repository = FakeUnidadeCurricularRepository()

    private val _uiState = MutableStateFlow(UnidadeCurricularUiState())
    val uiState: StateFlow<UnidadeCurricularUiState> = _uiState

    init { carregarUnidades() }

    fun onEvent(event: UnidadeCurricularEvent) {
        when (event) {
            UnidadeCurricularEvent.OnRetryClick -> carregarUnidades()
        }
    }

    private fun carregarUnidades() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                val unidades = repository.getUnidades()
                _uiState.update { it.copy(isLoading = false, unidades = unidades) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, errorMessage = "Erro ao carregar unidades.") }
            }
        }
    }
}
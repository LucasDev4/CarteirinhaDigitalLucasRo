package com.example.carteirinhadigital.feature.auth.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import com.example.carteirinhadigital.feature.auth.presentation.LoginViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: (UsuarioLogado) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let { onLoginSuccess(it) }
    }

    LoginContent(
        uiState = uiState,
        onEvent = viewModel::onEvent,
        modifier = modifier
    )
}

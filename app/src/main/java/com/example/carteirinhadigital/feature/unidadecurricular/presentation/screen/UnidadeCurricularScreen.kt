package com.example.carteirinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carteirinhadigital.core.designsystem.component.AppDrawerItem
import com.example.carteirinhadigital.core.designsystem.component.AppScaffold
import com.example.carteirinhadigital.feature.unidadecurricular.presentation.UnidadeCurricularViewModel

@Composable
fun UnidadeCurricularScreen(
    usuarioNome: String,
    usuarioDescricao: String,
    drawerItems: List<AppDrawerItem>,
    onLogoutClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UnidadeCurricularViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    AppScaffold(
        title = "Unidades Curriculares",
        subtitle = null,
        usuarioNome = usuarioNome,
        usuarioDescricao = usuarioDescricao,
        drawerItems = drawerItems,
        onLogoutClick = onLogoutClick,
        showBackButton = true,
        onBackClick = onBackClick
    ) { innerPadding ->
        UnidadeCurricularContent(
            uiState = uiState,
            onEvent = viewModel::onEvent,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
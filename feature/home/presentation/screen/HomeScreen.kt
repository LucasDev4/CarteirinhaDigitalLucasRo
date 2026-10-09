package com.example.carteirinhadigital.feature.home.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.carteirinhadigital.core.designsystem.component.AppDrawerItem
import com.example.carteirinhadigital.core.designsystem.component.AppScaffold

@Composable
fun HomeScreen(
    usuarioNome: String,
    usuarioDescricao: String,
    drawerItems: List<AppDrawerItem>,
    onLogoutClick: () -> Unit,
    onCarteirinhaClick: () -> Unit,
    onUnidadesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    AppScaffold(
        title = "Início",
        subtitle = null,
        usuarioNome = usuarioNome,
        usuarioDescricao = usuarioDescricao,
        drawerItems = drawerItems,
        onLogoutClick = onLogoutClick
    ) { innerPadding ->
        HomeContent(
            usuarioNome = usuarioNome,
            onCarteirinhaClick = onCarteirinhaClick,
            onUnidadesClick = onUnidadesClick,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

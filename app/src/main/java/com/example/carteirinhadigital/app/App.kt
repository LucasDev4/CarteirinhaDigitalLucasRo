package com.example.carteirinhadigital.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.carteirinhadigital.core.designsystem.navigation.AppNavHost
import com.example.carteirinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme

@Composable
fun App() {
    CarteirinhaDigitalTheme {
        val navController = rememberNavController()
        AppNavHost(navController = navController)
    }
}

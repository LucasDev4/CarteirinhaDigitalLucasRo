package com.example.carteirinhadigital.feature.auth.data.repository

import com.example.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import kotlinx.coroutines.delay

class FakeAuthRepository : AuthRepository {
    override suspend fun login(usuario: String, senha: String): UsuarioLogado? {
        delay(1500)
        return if (usuario == "maria" && senha == "456") {
            UsuarioLogado(
                id = "002",
                nome = "Lucas Rodrigues",
                token = "fake-token-senai-2024"
            )
        } else {
            null
        }
    }
}

package com.example.carteirinhadigital.feature.carteirinha.data.repository

import com.example.carteirinhadigital.feature.carteirinha.domain.model.Carteirinha

interface CarteirinhaRepository {
    suspend fun getCarteirinha(usuarioId: String): Carteirinha?
}

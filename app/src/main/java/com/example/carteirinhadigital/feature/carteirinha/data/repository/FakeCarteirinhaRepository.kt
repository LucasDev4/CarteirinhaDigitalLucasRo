package com.example.carteirinhadigital.feature.carteirinha.data.repository

import com.example.carteirinhadigital.feature.carteirinha.domain.model.Carteirinha
import kotlinx.coroutines.delay

class FakeCarteirinhaRepository : CarteirinhaRepository {
    override suspend fun getCarteirinha(usuarioId: String): Carteirinha? {
        delay(1000)
        return Carteirinha(
            nome = "Lucas Rodrigues Ferraz",
            curso = "Desenvolvimento de Sistemas",
            turma = "2 DEVEST - B",
            matricula = "90000000001756396163",
            unidade = "SENAI Anchieta",
            status = "Ativo",
            qrCodeContent = "SENAI:90000000001756396163:Aluno SENAI:Desenvolvimento de Sistemas"
        )
    }
}

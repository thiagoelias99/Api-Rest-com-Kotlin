package com.telias.forum.models

import java.time.LocalDateTime

class Resposta(
        val id: Long? = null,
        val mensagem: String,
        val dataCriacao: LocalDateTime = LocalDateTime.now(),
        val autor: Usuario,
        val topico: Topico,
        val solucao: Boolean = false
)

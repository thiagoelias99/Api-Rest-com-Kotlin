package com.telias.forum.dto

import com.telias.forum.models.StatusTopico
import java.time.LocalDateTime

data class TopicoView (
    val id: Long,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
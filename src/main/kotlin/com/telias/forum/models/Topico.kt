package com.telias.forum.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topico (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
        //Um tópico tem um curso
        //Um curso tem vários tópicos
    @ManyToOne
        val curso: Curso,
    @ManyToOne
        val autor: Usuario,
    @Enumerated(value = EnumType.STRING)
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
        //Um tópico tem várias respostas
        //Resposta tem um tópico
    @OneToMany(mappedBy = "topico")
        val respostas: List<Resposta> = ArrayList()
)
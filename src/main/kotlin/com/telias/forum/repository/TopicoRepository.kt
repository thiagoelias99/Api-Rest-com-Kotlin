package com.telias.forum.repository

import com.telias.forum.models.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {

    //Seguir o padrão que o JPA monta as queries automaticamente
    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>
}
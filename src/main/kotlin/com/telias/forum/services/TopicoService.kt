package com.telias.forum.services

import com.telias.forum.dto.TopicoDto
import com.telias.forum.dto.TopicoPost
import com.telias.forum.dto.TopicoPut
import com.telias.forum.dto.TopicoView
import com.telias.forum.exception.NotFoundException
import com.telias.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val dto: TopicoDto,
    private val notFoundMessage: String = "Topico não encontrado"
) {
    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        val topicos = if (nomeCurso == null){
            repository.findAll(paginacao)
        } else{
            repository.findByCursoNome(nomeCurso, paginacao)
        }

        return topicos.map { t -> dto.toView(t) }
    }

    fun buscarPorId(id: Long): TopicoView? {
        return dto.toView(repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) })
    }

    fun cadastrar(data: TopicoPost): TopicoView {
        return dto.toView(repository.save(dto.fromPost(data)))
    }

    fun atualizar(data: TopicoPut): TopicoView {
        val topico = repository.findById(data.id).orElseThrow{ NotFoundException(notFoundMessage) }
        topico.titulo = data.titulo
        topico.mensagem = data.mensagem
        return dto.toView(repository.save(topico))
    }

    fun deletar(id: Long) {
        repository.delete(repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) })
    }
}
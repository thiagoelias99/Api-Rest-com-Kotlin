package com.telias.forum.services

import com.telias.forum.database.TopicoEntity
import com.telias.forum.dto.*
import com.telias.forum.exception.NotFoundException
import com.telias.forum.models.Curso
import com.telias.forum.models.Topico
import com.telias.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: TopicoEntity,
    private val topicoDto: TopicoDto,
    private val notFoundMessage: String = "Topico não encontrado"
) {
    fun listar(): List<TopicoView> {
        return topicos.getList().stream().map { t -> topicoDto.toView(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView? {
        return topicos.getList().stream().filter { t -> t.id == id }.findFirst().map { t -> topicoDto.toView(t) }
            .orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun cadastrar(form: TopicoPost): TopicoView {
        val topico = topicoDto.fromPost(form)
        topico.id = topicos.getList().size.toLong() + 1
        topicos.updateList(topicos.getList().plus(topico))
        return topicoDto.toView(topico)
    }

    fun atualizar(form: TopicoPut): TopicoView {
        val topico =
            topicos.getList().stream().filter { t -> t.id == form.id }.findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        val topicoAtualizado = topicoDto.fromPut(form)

        topicos.updateList(topicos.getList().minus(topico).plus(topicoAtualizado))
        return topicoDto.toView(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico =
            topicos.getList().stream().filter { t -> t.id == id }.findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        topicos.updateList(topicos.getList().minus(topico))
    }
}
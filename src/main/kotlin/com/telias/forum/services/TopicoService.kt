package com.telias.forum.services

import com.telias.forum.dto.AtualizaçãoTopicoForm
import com.telias.forum.dto.NotoTopicoForm
import com.telias.forum.dto.TopicoView
import com.telias.forum.exception.NotFoundException
import com.telias.forum.mapper.TopicoFormMapper
import com.telias.forum.mapper.TopicoViewMapper
import com.telias.forum.models.Curso
import com.telias.forum.models.Topico
import com.telias.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado"
) {

    init {
        val topico1 = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis em kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Sara",
                email = "sara@email.com"
            )
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Duvida Kotlin 2",
            mensagem = "Variaveis em kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Sara",
                email = "sara@email.com"
            )
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Duvida Kotlin 3",
            mensagem = "Variaveis em kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Sara",
                email = "sara@email.com"
            )
        )

        topicos = Arrays.asList(topico1, topico2, topico3)
    }

    fun listar(): List<TopicoView> {

        return topicos.stream().map { t -> topicoViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView? {
        return topicos.stream().filter { t -> t.id == id }.findFirst().map { t -> topicoViewMapper.map(t) }.orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun cadastrar(form: NotoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizaçãoTopicoForm): TopicoView {
        val topico =
            topicos.stream().filter { t -> t.id == form.id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )

        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico =
            topicos.stream().filter { t -> t.id == id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        topicos = topicos.minus(topico)
    }
}
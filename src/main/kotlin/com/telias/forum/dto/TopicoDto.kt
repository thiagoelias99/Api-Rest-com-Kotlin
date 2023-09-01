package com.telias.forum.dto

import com.telias.forum.database.TopicoEntity
import com.telias.forum.exception.NotFoundException
import com.telias.forum.models.StatusTopico
import com.telias.forum.models.Topico
import com.telias.forum.services.CursoService
import com.telias.forum.services.UsuarioService
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TopicoDto(
    private val topicos: TopicoEntity,
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) {
    fun fromPost(topicoPost: TopicoPost): Topico {
        return Topico(
            titulo = topicoPost.titulo,
            mensagem = topicoPost.mensagem,
            curso = cursoService.buscarPorId2(topicoPost.idCurso),
            autor = usuarioService.buscarPorId2(topicoPost.idAutor),
        )
    }

    fun fromPut(topicoPut: TopicoPut): Topico {
        val topico =
            topicos.getList().stream().filter { t -> t.id == topicoPut.id }.findFirst().orElseThrow { NotFoundException() }

        topico?.let { topico ->
            return Topico(
                id = topico.id,
                titulo = topicoPut.titulo,
                mensagem = topicoPut.mensagem,
                autor = topico.autor,
                curso = topico.curso,
                dataCriacao = topico.dataCriacao,
                status = topico.status,
                respostas = topico.respostas
            )
        }
        throw NotFoundException()
    }

    fun toView(topico: Topico): TopicoView {
        return TopicoView(
            id = topico.id!!,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        )
    }
}

class TopicoPost(
    @field:NotEmpty @field:Size(min = 5, max = 100) val titulo: String,
    @field:NotEmpty val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long,
)

class TopicoPut(
    @field:NotNull val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 100) val titulo: String,
    @field:NotEmpty
    val mensagem: String,
)

class TopicoView(
    val id: Long,
    var titulo: String,
    var mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
package com.telias.forum.dto

import com.telias.forum.database.CursoEntity
import com.telias.forum.exception.NotFoundException
import com.telias.forum.models.Curso
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.springframework.stereotype.Component

@Component
class CursoDto(
    private val db: CursoEntity
) {
    fun fromPost(data: CursoPost): Curso {
        return Curso(
            nome = data.nome,
            categoria = data.categoria
        )
    }

    fun fromPut(data: CursoPut): Curso {
        val curso =
            db.getList().stream().filter { t -> t.id == data.id }.findFirst().orElseThrow { NotFoundException() }

        curso?.let { curso ->
            return Curso(
                id = curso.id,
                nome = data.nome,
                categoria = data.categoria)
        }
        throw NotFoundException()
    }

    fun toView(curso: Curso): CursoView {
        return CursoView(
            id = curso.id!!,
            nome = curso.nome,
            categoria = curso.categoria
        )
    }
}

class CursoPost(
    @field:NotEmpty val nome: String,
    @field:NotEmpty val categoria: String,
)

class CursoPut(
    @field:NotNull val id: Long,
    @field:NotEmpty val nome: String,
    @field:NotEmpty val categoria: String,
)

class CursoView(
    val id: Long,
    var nome: String,
    var categoria: String,
)
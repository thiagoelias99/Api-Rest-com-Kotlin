package com.telias.forum.services

import com.telias.forum.database.CursoEntity
import com.telias.forum.dto.CursoDto
import com.telias.forum.dto.CursoPost
import com.telias.forum.dto.CursoPut
import com.telias.forum.dto.CursoView
import com.telias.forum.exception.NotFoundException
import com.telias.forum.models.Curso
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CursoService(
    private var db: CursoEntity,
    private val dto: CursoDto,
    private val notFoundMessage: String = "Curso não encontrado"
) {
    fun listar(): List<CursoView> {
        return db.getList().stream().map { t -> dto.toView(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): CursoView? {
        return db.getList().stream().filter { t -> t.id == id }.findFirst().map { t -> dto.toView(t) }
            .orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun buscarPorId2(id: Long): Curso {
        return db.getList().stream().filter { t -> t.id == id }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun cadastrar(form: CursoPost): CursoView {
        val curso = dto.fromPost(form)
        curso.id = db.getList().size.toLong() + 1
        db.updateList(db.getList().plus(curso))
        return dto.toView(curso)
    }

    fun atualizar(form: CursoPut): CursoView {
        val curso =
            db.getList().stream().filter { t -> t.id == form.id }.findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        val topicoAtualizado = dto.fromPut(form)

        db.updateList(db.getList().minus(curso).plus(topicoAtualizado))
        return dto.toView(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val curso =
            db.getList().stream().filter { t -> t.id == id }.findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        db.updateList(db.getList().minus(curso))
    }
}
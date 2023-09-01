package com.telias.forum.services

import com.telias.forum.dto.CursoDto
import com.telias.forum.dto.CursoPost
import com.telias.forum.dto.CursoPut
import com.telias.forum.dto.CursoView
import com.telias.forum.exception.NotFoundException
import com.telias.forum.models.Curso
import com.telias.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CursoService(
    private val repository: CursoRepository,
    private val dto: CursoDto,
    private val notFoundMessage: String = "Curso não encontrado"
) {
    fun listar(): List<CursoView> {
        return repository.findAll().stream().map { t -> dto.toView(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): CursoView? {
        return dto.toView(repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) })
    }

    fun buscarPorId2(id: Long): Curso {
        return repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun cadastrar(data: CursoPost): CursoView {
        return dto.toView(repository.save(dto.fromPost(data)))
    }

    fun atualizar(data: CursoPut): CursoView {
        val curso = repository.findById(data.id).orElseThrow{ NotFoundException(notFoundMessage) }
        curso.nome = data.nome
        curso.categoria = data.categoria
        return dto.toView(repository.save(curso))
    }

    fun deletar(id: Long) {
        repository.delete(repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) })
    }
}
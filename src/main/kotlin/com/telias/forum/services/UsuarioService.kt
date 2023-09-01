package com.telias.forum.services

import com.telias.forum.dto.UsuarioDto
import com.telias.forum.dto.UsuarioPost
import com.telias.forum.dto.UsuarioPut
import com.telias.forum.dto.UsuarioView
import com.telias.forum.exception.NotFoundException
import com.telias.forum.models.Usuario
import com.telias.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val dto: UsuarioDto,
    private val notFoundMessage: String = "Usuario não encontrado"
) {
    fun listar(): List<UsuarioView> {
        return repository.findAll().stream().map { t -> dto.toView(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): UsuarioView? {
        return dto.toView(repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) })
    }

    fun buscarPorId2(id: Long): Usuario {
        return repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun cadastrar(data: UsuarioPost): UsuarioView {
        return dto.toView(repository.save(dto.fromPost(data)))
    }

    fun atualizar(data: UsuarioPut): UsuarioView {
        val usuario = repository.findById(data.id).orElseThrow{ NotFoundException(notFoundMessage) }
        usuario.nome = data.nome
        return dto.toView(repository.save(usuario))
    }

    fun deletar(id: Long) {
        repository.delete(repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) })
    }
}

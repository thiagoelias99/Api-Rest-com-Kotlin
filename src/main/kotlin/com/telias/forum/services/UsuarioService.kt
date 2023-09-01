package com.telias.forum.services

import com.telias.forum.database.UsuarioEntity
import com.telias.forum.dto.*
import com.telias.forum.exception.NotFoundException
import com.telias.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UsuarioService(
    private var usuarios: UsuarioEntity,
    private val usuarioDto: UsuarioDto,
    private val notFoundMessage: String = "Usuario não encontrado"
) {
    fun listar(): List<UsuarioView> {
        return usuarios.getList().stream().map { t -> usuarioDto.toView(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): UsuarioView? {
        return usuarios.getList().stream().filter { t -> t.id == id }.findFirst().map { t -> usuarioDto.toView(t) }
            .orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun buscarPorId2(id: Long): Usuario {
        return usuarios.getList().stream().filter { t -> t.id == id }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun cadastrar(form: UsuarioPost): UsuarioView {
        val usuario = usuarioDto.fromPost(form)
        usuario.id = usuarios.getList().size.toLong() + 1
        usuarios.updateList(usuarios.getList().plus(usuario))
        return usuarioDto.toView(usuario)
    }

    fun atualizar(form: UsuarioPut): UsuarioView {
        val usuario =
            usuarios.getList().stream().filter { t -> t.id == form.id }.findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        val topicoAtualizado = usuarioDto.fromPut(form)

        usuarios.updateList(usuarios.getList().minus(usuario).plus(topicoAtualizado))
        return usuarioDto.toView(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val usuario =
            usuarios.getList().stream().filter { t -> t.id == id }.findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        usuarios.updateList(usuarios.getList().minus(usuario))
    }
}

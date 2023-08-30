package com.telias.forum.services

import com.telias.forum.models.Curso
import com.telias.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Sara",
            email = "sara@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { u ->
            u.id == id
        }.findFirst().get()
    }

}

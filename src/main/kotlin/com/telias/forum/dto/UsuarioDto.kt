package com.telias.forum.dto

import com.telias.forum.models.Usuario
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.stereotype.Component

@Component
class UsuarioDto() {
    fun fromPost(usuarioPost: UsuarioPost): Usuario {
        return Usuario(
            nome = usuarioPost.nome,
            email = usuarioPost.email
        )
    }

    fun toView(usuario: Usuario): UsuarioView {
        return UsuarioView(
            id = usuario.id!!,
            nome = usuario.nome,
            email = usuario.email
        )
    }
}

class UsuarioPost(
    @field:NotEmpty @field:Size(min = 1, max = 100) val nome: String,
    @field:NotEmpty @field:Size(min = 5, max = 100) val email: String,
)

class UsuarioPut(
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 1, max = 100) val nome: String,
)

class UsuarioView(
    val id: Long,
    var nome: String,
    var email: String,
)
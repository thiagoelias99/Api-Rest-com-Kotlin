package com.telias.forum.database

import com.telias.forum.models.Usuario
import org.springframework.stereotype.Component
import java.util.*

@Component
data class UsuarioEntity (private var usuarios: List<Usuario> = ArrayList()){

    init {
        val usuario1 = Usuario(
            id = 1,
            nome = "Sara",
            email = "sara@email.com"
        )

        val usuario2 = Usuario(
            id = 2,
            nome = "Bia",
            email = "bia@email.com"
        )

        val usuario3 = Usuario(
            id = 3,
            nome = "Ana",
            email = "ana@email.com"
        )

        usuarios = Arrays.asList(usuario1, usuario2, usuario3)
    }

    fun getList(): List<Usuario>{
        return usuarios
    }

    fun updateList(list: List<Usuario>){
        usuarios = list
    }
}
package com.telias.forum.database

import com.telias.forum.models.Curso
import com.telias.forum.models.Topico
import com.telias.forum.models.Usuario
import org.springframework.stereotype.Component
import java.util.*

@Component
data class TopicoEntity (private var topicos: List<Topico> = ArrayList()){

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

    fun getList(): List<Topico>{
        return topicos
    }

    fun updateList(list: List<Topico>){
        topicos = list
    }
}
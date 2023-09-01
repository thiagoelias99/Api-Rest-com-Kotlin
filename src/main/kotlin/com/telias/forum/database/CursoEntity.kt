package com.telias.forum.database

import com.telias.forum.models.Curso
import org.springframework.stereotype.Component
import java.util.*

@Component
data class CursoEntity (private var cursos: List<Curso> = ArrayList()){

    init {
        val curso1 = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        val curso2 = Curso(
            id = 2,
            nome = "TypeScript",
            categoria = "Programação"
        )

        val curso3 = Curso(
            id = 3,
            nome = "Swift",
            categoria = "Mobile"
        )

        cursos = Arrays.asList(curso1, curso2, curso3)
    }

    fun getList(): List<Curso>{
        return cursos
    }

    fun updateList(list: List<Curso>){
        cursos = list
    }
}
package com.telias.forum.controllers

import com.telias.forum.dto.CursoPost
import com.telias.forum.dto.CursoPut
import com.telias.forum.dto.CursoView
import com.telias.forum.services.CursoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/cursos")
class CursoController(private val service: CursoService) {

    @GetMapping
    fun listar(): List<CursoView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): CursoView?{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: CursoPost,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CursoView>{
        val cursoView = service.cadastrar(form)
        val uri = uriBuilder.path("/cursos/${cursoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(cursoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: CursoPut): ResponseEntity<CursoView>{
        val usuarioView = service.atualizar(form)
        return ResponseEntity.ok(usuarioView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }
}
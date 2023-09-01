package com.telias.forum.controllers

import com.telias.forum.dto.UsuarioPost
import com.telias.forum.dto.UsuarioPut
import com.telias.forum.dto.UsuarioView
import com.telias.forum.services.UsuarioService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val service: UsuarioService) {

    @GetMapping
    fun listar(): List<UsuarioView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): UsuarioView?{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: UsuarioPost,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UsuarioView>{
        val usuarioView = service.cadastrar(form)
        val uri = uriBuilder.path("/usuarios/${usuarioView.id}").build().toUri()
        return ResponseEntity.created(uri).body(usuarioView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: UsuarioPut): ResponseEntity<UsuarioView>{
        val usuarioView = service.atualizar(form)
        return ResponseEntity.ok(usuarioView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }
}
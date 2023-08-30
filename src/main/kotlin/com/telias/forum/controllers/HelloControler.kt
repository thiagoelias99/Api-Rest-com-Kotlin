package com.telias.forum.controllers

import com.telias.forum.models.Topico
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloControler {

    @GetMapping
    fun hello(): String{
        return "Hello World 2"
    }
}
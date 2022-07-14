package com.br.livraria.controller

import com.br.livraria.model.BookRegistron
import com.br.livraria.service.BookService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")

class BookController(private val service: BookService) {

    @PostMapping
    fun create(@RequestBody account: BookRegistron) = service.create(account) // irá salvar o livro no banco de dados

    @GetMapping
    fun getAll(): List<BookRegistron> = service.getAll() //comunicação com o banco de dados e exibe todos os livros

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long) = service.getbyId(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody account: BookRegistron) = service.update(id,account)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)

}
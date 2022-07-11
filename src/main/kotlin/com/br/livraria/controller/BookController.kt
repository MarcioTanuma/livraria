package com.br.livraria

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

class BookController(private val repository: BookRegistronRepository) {

    @PostMapping
    fun create(@RequestBody account: BookRegistron) = repository.save(account) // irá salvar o livro no banco de dados

    @GetMapping
    fun getAll(): List<BookRegistron> = repository.findAll() //comunicação com o banco de dados e exibe todos os livros

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long) : ResponseEntity<BookRegistron> =
        repository.findById(id).map {
        ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody account: BookRegistron) : ResponseEntity<BookRegistron> =
        repository.findById(id).map {
            val accountToUpdate = it.copy(
                titulo = account.titulo,
                autor = account.autor,
                editora = account.editora,
                ano = account.ano,
                preco = account.preco,
            )
            ResponseEntity.ok(repository.save(accountToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
        repository.findById(id).map {
        repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}
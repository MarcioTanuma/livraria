package com.br.livraria.service

import com.br.livraria.model.BookRegistron
import com.br.livraria.repository.BookRegistronRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BookService (private val repository: BookRegistronRepository) {

        fun create(account: BookRegistron) = repository.save(account)

        fun getAll(): List<BookRegistron> = repository.findAll()

        fun getbyId(id: Long) : ResponseEntity<BookRegistron> =
            repository.findById(id).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

        fun update(id: Long, account: BookRegistron) : ResponseEntity<BookRegistron> =
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

        fun delete(id: Long) : ResponseEntity<Void> =
            repository.findById(id).map {
                repository.delete(it)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
}

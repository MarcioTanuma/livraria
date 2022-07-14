package com.br.livraria.repository

import com.br.livraria.model.BookRegistron
import org.springframework.data.jpa.repository.JpaRepository

interface BookRegistronRepository : JpaRepository<BookRegistron, Long> {
 //   fun findByTitulo : BookRegistron (var titulo: String?) checar
}
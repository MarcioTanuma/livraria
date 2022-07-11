package com.br.livraria

import org.springframework.data.jpa.repository.JpaRepository

interface BookRegistronRepository : JpaRepository<BookRegistron, Long> {
}
package com.br.livraria

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "Books") // será o nome da tabela = Books
data class BookRegistron (
    @Id @GeneratedValue
    var id: Long? = null, // iniciado como nulo, pois será adicionado pelo JPA
    val titulo: String,
    val autor: String,
    val editora: String,
    val ano: Int,
    val preco: Double,
)
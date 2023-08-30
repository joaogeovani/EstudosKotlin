package com.example.estudoskotlin.dao

import com.example.estudoskotlin.model.Produtos

class ProdutosDAO {

    fun adicionar(produto: Produtos) {
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produtos> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produtos>()
    }

}
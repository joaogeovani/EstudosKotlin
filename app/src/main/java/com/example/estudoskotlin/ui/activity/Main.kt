package com.example.estudoskotlin.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.estudoskotlin.R
import com.example.estudoskotlin.model.Produtos
import com.example.estudoskotlin.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Bem vindo(a)", Toast.LENGTH_SHORT).show()
        val listaProdutos = findViewById<RecyclerView>(R.id.listaProdutos)
        listaProdutos.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produtos(nome = "Teste",
                    descricao = "teste desc",
                    valor = BigDecimal("19.99")
            ),
            Produtos(nome = "Teste1",
                    descricao = "teste desc1",
                    valor = BigDecimal("29.99")
            ),
            Produtos(nome = "Teste2",
                    descricao = "teste desc2",
                    valor = BigDecimal("39.99")
            )
        ))
    }
}
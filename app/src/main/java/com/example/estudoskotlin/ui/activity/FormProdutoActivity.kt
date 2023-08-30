package com.example.estudoskotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.estudoskotlin.R
import com.example.estudoskotlin.dao.ProdutosDAO
import com.example.estudoskotlin.model.Produtos
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        salvarProduto()
    }

    private fun salvarProduto() {
        val salvarProduto = findViewById<Button>(R.id.botao_salvar)
        val dao = ProdutosDAO()
        salvarProduto.setOnClickListener {
            val produtoCriado = criaProduto()
            dao.adicionar(produtoCriado)
            finish()
            Toast.makeText(this, "Produto Salvo!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun criaProduto(): Produtos {
        val campoNome = findViewById<EditText>(R.id.activity_form_produto_nome)
        val nome = campoNome.text.toString()
        val campoDesc = findViewById<EditText>(R.id.activity_form_produto_desc)
        val desc = campoDesc.text.toString()
        val campoValor = findViewById<EditText>(R.id.activity_form_produto_valor)
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produtos(
            nome = nome,
            descricao = desc,
            valor = valor
        )
    }

}
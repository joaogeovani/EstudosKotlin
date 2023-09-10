package com.example.estudoskotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.estudoskotlin.R
import com.example.estudoskotlin.dao.ProdutosDAO
import com.example.estudoskotlin.databinding.ActivityFormProdutoBinding
import com.example.estudoskotlin.model.Produtos
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        salvarProduto()
    }

    private fun salvarProduto() {
        val salvarProduto = binding.botaoSalvar
        val dao = ProdutosDAO()
        salvarProduto.setOnClickListener {
            val produtoCriado = criaProduto()
            dao.adicionar(produtoCriado)
            finish()
            Toast.makeText(this, "Produto Salvo!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun criaProduto(): Produtos {
        val campoNome = binding.activityFormProdutoNome
        val nome = campoNome.text.toString()
        val campoDesc = binding.activityFormProdutoDesc
        val desc = campoDesc.text.toString()
        val campoValor = binding.activityFormProdutoValor
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
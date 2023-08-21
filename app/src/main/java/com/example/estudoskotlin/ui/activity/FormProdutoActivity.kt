package com.example.estudoskotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.estudoskotlin.R
import com.example.estudoskotlin.model.Produtos
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val salvarProduto = findViewById<Button>(R.id.botao_salvar)
        salvarProduto.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDesc = findViewById<EditText>(R.id.desc)
            val desc = campoDesc.text.toString()
            val campoValor = findViewById<EditText>(R.id.valor)
            val valorEmTexto = campoValor.text.toString()
            val valor = if(valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val produtoCriado = Produtos(
                nome = nome,
                descricao = desc,
                valor = valor
            )

            Log.i("FormProdutoActivity", "onCreate: $produtoCriado")
        }
    }

}
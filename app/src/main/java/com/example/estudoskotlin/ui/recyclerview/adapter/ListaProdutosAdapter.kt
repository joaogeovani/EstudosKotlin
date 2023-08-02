package com.example.estudoskotlin.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.estudoskotlin.R
import com.example.estudoskotlin.model.Produtos

class ListaProdutosAdapter(
        private val context: Context,
        private val produtos : List<Produtos>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produtos) {
            val item = itemView.findViewById<TextView>(R.id.produto)
            item.text = produto.nome
            val desc = itemView.findViewById<TextView>(R.id.descricao)
            desc.text = produto.descricao
            val preco = itemView.findViewById<TextView>(R.id.valor)
            preco.text = produto.valor.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size

}

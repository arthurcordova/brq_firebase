package com.mobwaysolutions.firebasetest.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.firebasetest.R

class PessoasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvNome: TextView = itemView.findViewById(R.id.tvNome)
    private val tvSobrenome: TextView = itemView.findViewById(R.id.tvSobrenome)
    val ivDelete: ImageView = itemView.findViewById(R.id.ivDelete)
    val ivEdit: ImageView = itemView.findViewById(R.id.ivEdit)

    fun preencher(pessoa: Pessoa) {
        tvNome.text = pessoa.nome
        tvSobrenome.text = pessoa.sobrenome
    }

}
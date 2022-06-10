package com.mobwaysolutions.firebasetest.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.firebasetest.R

class PessoasAdapter(private val interfaceClicavel: PessoaClicavel) :
    RecyclerView.Adapter<PessoasViewHolder>() {

    val listaDePessoas: MutableList<Pessoa> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoasViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lista_pessoa, parent, false)
        return PessoasViewHolder(view)
    }

    override fun onBindViewHolder(holder: PessoasViewHolder, position: Int) {
        val pessoaSelecionada = listaDePessoas[position]
        holder.preencher(pessoaSelecionada)
        holder.ivEdit.setOnClickListener { interfaceClicavel.onClickEdit(pessoaSelecionada) }
        holder.ivDelete.setOnClickListener { interfaceClicavel.onClickDelete(pessoaSelecionada) }
    }

    override fun getItemCount(): Int {
        return listaDePessoas.size
    }

    fun atualizarLista(novaLista: List<Pessoa>) {
        listaDePessoas.clear()
        listaDePessoas.addAll(novaLista)
        notifyDataSetChanged()
    }

}
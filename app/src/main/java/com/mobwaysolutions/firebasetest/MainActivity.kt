package com.mobwaysolutions.firebasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mobwaysolutions.firebasetest.model.Pessoa
import com.mobwaysolutions.firebasetest.model.PessoasAdapter

class MainActivity : AppCompatActivity() {

    lateinit var buttonSave: Button
    lateinit var tilNome: TextInputLayout
    lateinit var tilSobrenome: TextInputLayout
    lateinit var rvListaPessoas: RecyclerView
    private val pessoaAdapter = PessoasAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carregarComponentes()
        configurarRecyclerView()

        buttonSave.setOnClickListener {
            val pessoa: Pessoa? = validarCamposDaTela()
            if (pessoa != null) {
                saveToFirebase(pessoa)
            } else {
                tilNome.error = "Por favor preencha o campo"
                tilSobrenome.error = "Por favor preencha o campo"
            }
        }

        fetchDataFromFirebase()
    }

    private fun carregarComponentes() {
        buttonSave = findViewById(R.id.btSave)
        tilNome = findViewById(R.id.tilNome)
        tilSobrenome = findViewById(R.id.tilSobrenome)
        rvListaPessoas = findViewById(R.id.rvListaPessoas)
    }

    private fun configurarRecyclerView() {
        rvListaPessoas.adapter = pessoaAdapter
        rvListaPessoas.layoutManager = LinearLayoutManager(this)
    }

    private fun validarCamposDaTela(): Pessoa? {
        if (tilNome.editText?.text.toString().isEmpty() || tilSobrenome.editText?.text.toString()
                .isEmpty()
        ) {
            return null
        }
        return Pessoa(
            nome = tilNome.editText?.text.toString(),
            sobrenome = tilSobrenome.editText?.text.toString()
        )
    }

    private fun saveToFirebase(pessoa: Pessoa) {
        val user = hashMapOf(
            "nome" to pessoa.nome,
            "sobrenome" to pessoa.sobrenome
        )

        Firebase.firestore
            .collection("meus_usuarios")
            .add(user)
            .addOnSuccessListener { documentReference ->
                println("DocumentSnapshot added with ID: ${documentReference.id}")
                tilNome.error = null
                tilSobrenome.error = null

                fetchDataFromFirebase()
            }
            .addOnFailureListener { e ->
                println("Error adding document: ${e.message}")
            }
    }

    private fun fetchDataFromFirebase() {
        Firebase.firestore.collection("meus_usuarios")
            .get()
            .addOnSuccessListener { result ->
                val novaLista = mutableListOf<Pessoa>()
                for (document in result) {
                    novaLista.add(Pessoa.convertFromFBToModel(document))
                }
                // Atualizar nossa recyclerview
                pessoaAdapter.atualizarLista(novaLista)
            }
            .addOnFailureListener { exception ->
                println("Error getting documents.")
            }
    }
}
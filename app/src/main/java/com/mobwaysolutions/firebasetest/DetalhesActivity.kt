package com.mobwaysolutions.firebasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mobwaysolutions.firebasetest.model.Pessoa

class DetalhesActivity : AppCompatActivity() {

    lateinit var buttonSave: Button
    lateinit var tilNome: TextInputLayout
    lateinit var tilSobrenome: TextInputLayout
    lateinit var tilID: TextInputLayout

    private var parametroPessoa: Pessoa? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        carregarComponentes()

        parametroPessoa = intent.getSerializableExtra("pessoa_param") as? Pessoa

        parametroPessoa?.let {
            tilNome.editText?.setText(it.nome)
            tilSobrenome.editText?.setText(it.sobrenome)
            tilID.editText?.setText(it.id)
        }

        buttonSave.setOnClickListener {

            parametroPessoa?.nome = tilNome.editText?.text.toString()
            parametroPessoa?.sobrenome = tilSobrenome.editText?.text.toString()

            parametroPessoa?.let {
                updateData(it)
            }
        }
    }

    private fun carregarComponentes() {
        buttonSave = findViewById(R.id.btSave)
        tilNome = findViewById(R.id.tilNome)
        tilSobrenome = findViewById(R.id.tilSobrenome)
        tilID = findViewById(R.id.tilID)
    }

    private fun updateData(pessoa: Pessoa) {
        val user = hashMapOf(
            "nome" to pessoa.nome,
            "sobrenome" to pessoa.sobrenome
        )
        Firebase.firestore
            .collection("meus_usuarios")
            .document(pessoa.id ?: "")
            .set(user, SetOptions.merge())
            .addOnSuccessListener {
                finish()
            }
    }

}
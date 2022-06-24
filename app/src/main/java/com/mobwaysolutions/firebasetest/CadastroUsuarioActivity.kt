package com.mobwaysolutions.firebasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class CadastroUsuarioActivity : AppCompatActivity() {

    private lateinit var viewModel: CadastroUsuarioViewModel
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilSenha: TextInputLayout
    private lateinit var bSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)
        viewModel = ViewModelProvider(this)[CadastroUsuarioViewModel::class.java]

        initComponents()

        bSave.setOnClickListener {
            tilSenha.error = null
            viewModel.criarUsuario(
                tilEmail.editText?.text.toString(),
                tilSenha.editText?.text.toString()
            )
        }

        initObservers()
    }

    private fun initObservers() {
        viewModel.resultState.observe(this) {
            if (it == null) {
                tilSenha.error = "Usuário ou senha inválidos."
            } else {
                // Ir para tela de authenticacao
            }
        }
    }

    private fun initComponents() {
        tilEmail = findViewById(R.id.tilEmail)
        tilSenha = findViewById(R.id.tilSenha)
        bSave = findViewById(R.id.btSave)
    }
}
package com.mobwaysolutions.firebasetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class CadastroUsuarioActivity : AppCompatActivity() {

    private lateinit var viewModel: AuthenticationUsuarioViewModel
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilSenha: TextInputLayout
    private lateinit var bSave: Button
    private lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)
        viewModel = ViewModelProvider(this)[AuthenticationUsuarioViewModel::class.java]

        initComponents()

        bSave.setOnClickListener {
            tilSenha.error = null

            userPreferences.save(tilEmail.editText?.text.toString())
            viewModel.criarUsuario(
                tilEmail.editText?.text.toString(),
                tilSenha.editText?.text.toString()
            )
        }
        userPreferences = UserPreferences(this)
        tilEmail.editText?.setText(userPreferences.getSavedEmail())

        initObservers()
    }

    private fun initObservers() {
        viewModel.resultState.observe(this) {
            if (it == null) {
                tilSenha.error = "Usuário ou senha inválidos."
            } else {
                Intent(this, LoginUsuarioActivity::class.java).let {
                    startActivity(it)
                }
            }
        }
    }

    private fun initComponents() {
        tilEmail = findViewById(R.id.tilEmail)
        tilSenha = findViewById(R.id.tilSenha)
        bSave = findViewById(R.id.btSave)
    }
}
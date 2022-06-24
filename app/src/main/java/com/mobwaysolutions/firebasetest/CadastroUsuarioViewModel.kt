package com.mobwaysolutions.firebasetest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser

class CadastroUsuarioViewModel : ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    val resultState = MutableLiveData<FirebaseUser?>()

    fun criarUsuario(email: String, senha: String) {
        authenticationRepository.createUser(email, senha) { firebaseUser, e ->
            resultState.value = firebaseUser
        }
    }

}
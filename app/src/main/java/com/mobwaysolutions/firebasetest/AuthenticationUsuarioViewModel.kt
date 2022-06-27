package com.mobwaysolutions.firebasetest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser

class AuthenticationUsuarioViewModel : ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    val resultState = MutableLiveData<FirebaseUser?>()

    fun criarUsuario(email: String, senha: String) {
        if (email.isNotEmpty() && senha.isNotEmpty()) {
            authenticationRepository.createUser(email, senha) { firebaseUser, e ->
                resultState.value = firebaseUser
            }
        }
    }

    fun login(email: String, senha: String) {
        authenticationRepository.signInWithEmail(email, senha) { firebaseUser, e ->
            resultState.value = firebaseUser
        }
    }

}
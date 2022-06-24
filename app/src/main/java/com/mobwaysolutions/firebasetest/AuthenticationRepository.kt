package com.mobwaysolutions.firebasetest

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepository {

    fun createUser(email: String, senha: String, onResult: (FirebaseUser?, Exception?) -> Unit) {
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, senha)
            .addOnSuccessListener { authResult ->
                onResult.invoke(authResult.user, null)
            }
            .addOnFailureListener {
                onResult.invoke(null, it)
            }
    }

}
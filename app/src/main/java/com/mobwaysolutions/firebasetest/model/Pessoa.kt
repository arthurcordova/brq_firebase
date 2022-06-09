package com.mobwaysolutions.firebasetest.model

import com.google.firebase.firestore.QueryDocumentSnapshot

data class Pessoa(val nome: String, val sobrenome: String) {

    companion object {

        fun convertFromFBToModel(query : QueryDocumentSnapshot) : Pessoa {
            return Pessoa(
                nome = query.data["nome"] as String,
                sobrenome = query.data["sobrenome"] as String
            )
        }
    }

}

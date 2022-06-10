package com.mobwaysolutions.firebasetest.model

import com.google.firebase.firestore.QueryDocumentSnapshot
import java.io.Serializable

data class Pessoa(val id: String?, val nome: String, val sobrenome: String) : Serializable {

    companion object {

        fun convertFromFBToModel(query: QueryDocumentSnapshot): Pessoa {
            return Pessoa(
                id = query.id,
                nome = query.data["nome"] as String,
                sobrenome = query.data["sobrenome"] as String
            )
        }
    }

}

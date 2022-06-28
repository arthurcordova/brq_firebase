package com.mobwaysolutions.firebasetest.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mobwaysolutions.firebasetest.model.Pessoa

@Entity
data class UserLocalEntity(
    @PrimaryKey
    val id: String,
    val nome: String?,
    val sobreNome: String?
) {

    companion object {
        fun convertPessoaToUserLocalEntity(pessoa: Pessoa) : UserLocalEntity {
            return UserLocalEntity(
                pessoa.id!!,
                pessoa.nome,
                pessoa.sobrenome
            )
        }
    }
}
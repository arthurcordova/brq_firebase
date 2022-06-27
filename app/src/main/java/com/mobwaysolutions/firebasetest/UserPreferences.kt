package com.mobwaysolutions.firebasetest

import android.content.Context

class UserPreferences(context: Context) {

    private val sharedPref = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

    fun save(email: String) {
        sharedPref.edit().apply {
            putString("user_email", email)
        }.apply()
    }

    fun getSavedEmail(): String? {
        return sharedPref.getString("user_email", "e-mail não encontrado")
    }

}
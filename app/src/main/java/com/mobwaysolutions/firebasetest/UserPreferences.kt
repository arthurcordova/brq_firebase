package com.mobwaysolutions.firebasetest

import android.content.Context

class UserPreferences<T>(context: Context) : UserPreferenceActions {

    private val sharedPref = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

    fun save(key: SharedPrefKeys, valor: T) {
        when (valor) {
            is String -> {
                sharedPref.edit().apply {
                    putString(key.nomeChave, valor)
                }.apply()
            }
            is Int -> {
                sharedPref.edit().apply {
                    putInt(key.nomeChave, valor)
                }.apply()
            }
            is Boolean -> {
                sharedPref.edit().apply {
                    putBoolean(key.nomeChave, valor)
                }.apply()
            }
        }
    }

    override fun getByKeyString(key: SharedPrefKeys): String? {
        return sharedPref.getString(key.nomeChave, "")
    }

    override fun getByKeyInt(key: SharedPrefKeys): Int {
        return sharedPref.getInt(key.nomeChave, 0)
    }

    override fun getByKeyBoolean(key: SharedPrefKeys): Boolean {
        return sharedPref.getBoolean(key.nomeChave, false)
    }

}

enum class SharedPrefKeys(val nomeChave : String) {

    EMAIL("user_email"),
    SENHA("user_password")

}


package com.mobwaysolutions.firebasetest

interface UserPreferenceActions {

    fun getByKeyString(key: SharedPrefKeys): String?
    fun getByKeyInt(key: SharedPrefKeys): Int
    fun getByKeyBoolean(key: SharedPrefKeys): Boolean

}


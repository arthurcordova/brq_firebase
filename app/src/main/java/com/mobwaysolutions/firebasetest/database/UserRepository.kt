package com.mobwaysolutions.firebasetest.database

import android.content.Context
import com.mobwaysolutions.firebasetest.database.entity.UserLocalEntity

class UserRepository(context: Context) {

    private val database: AppDatabase? = AppDatabase.getInstance(context)

    fun insert(userLocalEntity: List<UserLocalEntity>) {
        database?.getUserDAO()?.insert(userLocalEntity)
    }

}
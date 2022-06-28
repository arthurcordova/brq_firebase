package com.mobwaysolutions.firebasetest.database

import android.content.Context
import com.mobwaysolutions.firebasetest.database.entity.UserLocalEntity

class UserRepositoryImpl(context: Context): DefaultRepository<UserLocalEntity> {

    private val database: AppDatabase? = AppDatabase.getInstance(context)

    override fun insert(target: List<UserLocalEntity>) {
        database?.getUserDAO()?.insert(target)    }

    override fun delete(target: UserLocalEntity) {
        database?.getUserDAO()?.delete(target)
    }

}
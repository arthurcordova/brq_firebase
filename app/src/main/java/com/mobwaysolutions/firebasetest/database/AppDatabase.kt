package com.mobwaysolutions.firebasetest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobwaysolutions.firebasetest.database.dao.UserDAO
import com.mobwaysolutions.firebasetest.database.entity.UserLocalEntity

@Database(
    version = 1,
    entities = [
        UserLocalEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDAO(): UserDAO

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_fb_database_db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }

    }
}
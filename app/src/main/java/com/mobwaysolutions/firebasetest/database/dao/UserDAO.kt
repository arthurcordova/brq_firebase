package com.mobwaysolutions.firebasetest.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mobwaysolutions.firebasetest.database.entity.UserLocalEntity

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userLocalEntity: List<UserLocalEntity>)

}
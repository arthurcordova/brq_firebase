package com.mobwaysolutions.firebasetest.database

interface DefaultRepository<T> {

    fun insert(target: List<T>)
    fun delete(target: T)

}
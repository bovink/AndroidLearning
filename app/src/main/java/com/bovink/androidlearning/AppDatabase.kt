package com.bovink.androidlearning

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author bovink
 * @since 2021/6/9
 */
@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val dabase_name = "Persons"
    }

    abstract fun userDao(): UserDao
}
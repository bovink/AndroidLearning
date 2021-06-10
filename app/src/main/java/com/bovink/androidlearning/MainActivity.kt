package com.bovink.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private var userDao: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            initDatabase()

            insertUser(User("meimei", "han"))
            queryUsers()
        }
    }

    fun initDatabase() {

        db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, AppDatabase.dabase_name
        ).build()
        userDao = db.userDao()
    }

    suspend fun insertUser(vararg users: User) {

        for (user in users) {
            userDao?.insertAll(user)
        }
    }

    suspend fun queryUsers() {

        val users: List<User>? = userDao?.getAll()
        for (user in users!!) {
            println("${user.uid}:${user.firstName}--${user.lastName}")
        }
    }
}
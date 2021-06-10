package com.bovink.androidlearning

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private var userDao: UserDao? = null
    private var result: Flow<List<User>>? = null

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button4)
        button.setOnClickListener {

            GlobalScope.launch {

                insertUser(User("meimei", "han"))
            }
        }

    }

    override fun onStart() {
        super.onStart()
        initData()
    }


    fun initData() {

        GlobalScope.launch {
            initDatabase()

            observableQuery()
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

    /**
     * 观察
     */
    suspend fun observableQuery() {

        result = userDao?.loadUsers()
        result!!.collect { users ->

            for (user in users) {
                println("${user.uid}:${user.firstName}--${user.lastName}")
            }
        }
    }
}
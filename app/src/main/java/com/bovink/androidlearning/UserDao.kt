package com.bovink.androidlearning

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * @author bovink
 * @since 2021/6/9
 */
@Dao
interface UserDao {
    @Query("SELECT* FROM user")
    fun getAll(): List<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

}
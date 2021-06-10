package com.bovink.androidlearning

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * @author bovink
 * @since 2021/6/9
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user")
    fun loadUsers(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: User)

    @Delete
    suspend fun delete(user: User)

}
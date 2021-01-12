package com.bovink.androidlearning;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * @author bovink
 * @since 2021/1/12
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getALl();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);

    @Delete
    void delete(User user);
}

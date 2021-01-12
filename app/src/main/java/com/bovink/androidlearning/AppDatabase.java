package com.bovink.androidlearning;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author bovink
 * @since 2021/1/12
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}

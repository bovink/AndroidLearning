package com.bovink.androidlearning

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author bovink
 * @since 2021/6/9
 */
@Entity
data class User(
        @ColumnInfo(name = "first_name") val firstName: String?,
        @ColumnInfo(name = "last_name") val lastName: String?,
        @PrimaryKey(autoGenerate = true) val uid: Int = 0
)
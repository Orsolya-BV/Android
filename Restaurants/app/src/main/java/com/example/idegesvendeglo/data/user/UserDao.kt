package com.example.idegesvendeglo.data.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.idegesvendeglo.data.user.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE )

    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY user_id ASC")

    fun readAllData():LiveData<User>

}
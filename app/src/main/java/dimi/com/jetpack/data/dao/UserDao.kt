package dimi.com.jetpack.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import dimi.com.jetpack.data.entity.UserEntity

@Dao
interface UserDao  {

    @Insert
    fun insert(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("DELETE FROM users")
    fun deleteAll()

}
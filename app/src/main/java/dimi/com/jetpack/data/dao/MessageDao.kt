package dimi.com.jetpack.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dimi.com.jetpack.data.entity.MessageEntity

@Dao
interface MessageDao {

    @Insert
    fun insert(message: MessageEntity)

    @Delete
    fun delete(message: MessageEntity)

    @Query("SELECT * FROM messages")
    fun getAll(): LiveData<List<MessageEntity>>

}
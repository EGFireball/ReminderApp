package dimi.com.jetpack.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dimi.com.jetpack.data.converter.DateConverter
import java.util.*

@Entity(tableName = "messages")
@TypeConverters(DateConverter::class)
data class MessageEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val message: String,
    val created: Date,
    val remindMe: Date?
)

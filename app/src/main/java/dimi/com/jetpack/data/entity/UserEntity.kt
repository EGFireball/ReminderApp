package dimi.com.jetpack.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userName: String,
    val pass: String,
    val email: String,
    val name: String
)
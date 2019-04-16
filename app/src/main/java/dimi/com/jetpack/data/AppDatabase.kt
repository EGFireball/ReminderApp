package dimi.com.jetpack.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dimi.com.jetpack.data.dao.LocationDao
import dimi.com.jetpack.data.dao.MessageDao
import dimi.com.jetpack.data.dao.UserDao
import dimi.com.jetpack.data.entity.LocationEntity
import dimi.com.jetpack.data.entity.MessageEntity
import dimi.com.jetpack.data.entity.UserEntity

@Database(entities = [UserEntity::class, LocationEntity::class, MessageEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun buildDb(context: Context) : AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                // Create database here
                val instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "db").build()
                INSTANCE = instance
                return instance
            }
        }
    }

    abstract fun userDao(): UserDao
    abstract fun locationDao(): LocationDao
    abstract fun messageDao(): MessageDao

}
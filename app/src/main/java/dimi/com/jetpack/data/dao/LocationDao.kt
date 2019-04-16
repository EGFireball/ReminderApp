package dimi.com.jetpack.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dimi.com.jetpack.data.entity.LocationEntity

@Dao
interface LocationDao {

    @Insert
    fun insert(location: LocationEntity)

    @Delete
    fun delete(location: LocationEntity)

    @Query("SELECT * FROM locations")
    fun getAll(): LiveData<List<LocationEntity>>
}
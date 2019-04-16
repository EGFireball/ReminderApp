package dimi.com.jetpack.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val locName: String,
    val lat: Double,
    val lng: Double,
    val type: String
)
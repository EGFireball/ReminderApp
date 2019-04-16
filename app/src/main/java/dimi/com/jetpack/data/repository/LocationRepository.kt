package dimi.com.jetpack.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import dimi.com.jetpack.data.AppDatabase
import dimi.com.jetpack.data.dao.LocationDao
import dimi.com.jetpack.data.entity.LocationEntity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LocationRepository(application: Application) {

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    private val locationDao: LocationDao

    init {
        val peopleDatabase = AppDatabase.buildDb(application)
        locationDao = peopleDatabase.locationDao()
    }

    fun getAllLocations(): LiveData<List<LocationEntity>> = locationDao.getAll()

    fun insertLocation(locationEntity: LocationEntity) {
        executorService.execute { locationDao.insert(locationEntity) }
    }
}
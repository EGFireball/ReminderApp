package dimi.com.jetpack.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import dimi.com.jetpack.data.entity.LocationEntity
import dimi.com.jetpack.data.repository.LocationRepository

class LocationVM(application: Application): AndroidViewModel(application) {

    private val locationRepository:LocationRepository = LocationRepository(application)

    fun getAllLocations(): LiveData<List<LocationEntity>> = locationRepository.getAllLocations()

    fun insertLocation(locationEntity: LocationEntity) {
        locationRepository.insertLocation(locationEntity)
    }
}
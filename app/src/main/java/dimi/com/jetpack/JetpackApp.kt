package dimi.com.jetpack

import android.app.Application
import dimi.com.jetpack.di.AppComponent
import dimi.com.jetpack.di.AppModule
import dimi.com.jetpack.di.DaggerAppComponent

class JetpackApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}

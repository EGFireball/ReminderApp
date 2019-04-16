package dimi.com.jetpack.di

import dagger.Component
import dimi.com.jetpack.JetpackApp
import dimi.com.jetpack.MainActivity
import dimi.com.jetpack.data.AppDatabase
import dimi.com.jetpack.data.dao.MessageDao
import dimi.com.jetpack.data.repository.MessageRepository
import dimi.com.jetpack.ui.main.viewmodel.MessageVM
import javax.inject.Singleton


@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(messageVM: MessageVM)

    fun getApplication(): JetpackApp

    fun getAppDb(): AppDatabase

    fun getMessageDao(): MessageDao

    fun getMessageRepository(): MessageRepository
}
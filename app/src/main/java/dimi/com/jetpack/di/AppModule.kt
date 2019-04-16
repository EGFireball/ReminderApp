package dimi.com.jetpack.di

import dagger.Module
import dagger.Provides
import dimi.com.jetpack.JetpackApp
import dimi.com.jetpack.data.AppDatabase
import dimi.com.jetpack.data.dao.MessageDao
import dimi.com.jetpack.data.repository.MessageRepository
import dimi.com.jetpack.ui.main.viewmodel.MessageVM
import java.util.concurrent.Executors
import javax.inject.Singleton


@Module
class AppModule(val app: JetpackApp)  {

    @Provides
    @Singleton
    fun getApplicationContext(): JetpackApp = app

    @Provides
    @Singleton
    fun provideRoomCurrencyDataSource(): AppDatabase = AppDatabase.buildDb(app)

    @Provides
    @Singleton
    fun provideMessageDao(appDatabase: AppDatabase) = appDatabase.messageDao()

    @Provides
    fun provideMessageRepository(messageDao: MessageDao) = MessageRepository(messageDao)
}
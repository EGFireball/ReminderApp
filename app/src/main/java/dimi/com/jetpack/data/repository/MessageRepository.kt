package dimi.com.jetpack.data.repository

import androidx.lifecycle.LiveData
import dimi.com.jetpack.data.dao.MessageDao
import dimi.com.jetpack.data.entity.MessageEntity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

class MessageRepository @Inject constructor(private val messageDao: MessageDao) {

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun getAllMessages(): LiveData<List<MessageEntity>> = messageDao.getAll()

    fun addMessage(messageEntity: MessageEntity) {
        executorService.execute { messageDao.insert(messageEntity) }
    }

}
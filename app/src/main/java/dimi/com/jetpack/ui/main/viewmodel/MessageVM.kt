package dimi.com.jetpack.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import dimi.com.jetpack.data.entity.MessageEntity
import dimi.com.jetpack.data.repository.MessageRepository
import javax.inject.Inject

class MessageVM(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var messageRepository: MessageRepository

    fun getAllMessages(): LiveData<List<MessageEntity>> = messageRepository.getAllMessages()

    fun addMessage(messageEntity: MessageEntity) {
        messageRepository.addMessage(messageEntity)
    }

}
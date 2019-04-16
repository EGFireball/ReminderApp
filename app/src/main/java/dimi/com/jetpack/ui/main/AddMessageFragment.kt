package dimi.com.jetpack.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import dimi.com.jetpack.JetpackApp
import dimi.com.jetpack.R
import dimi.com.jetpack.data.entity.MessageEntity
import dimi.com.jetpack.ui.main.viewmodel.MessageVM
import kotlinx.android.synthetic.main.add_message_fragment.*
import java.util.*

class AddMessageFragment : Fragment() {

    private lateinit var messageVm: MessageVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageVm = ViewModelProviders.of(this).get(MessageVM::class.java)
        JetpackApp.appComponent.inject(messageVm)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.add_message_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add.setOnClickListener {
            val reminderDate: Date = Calendar.getInstance().set //(calendar.date)
            val message = MessageEntity(0, message = message.text.toString(), Date(), null)
            messageVm.addMessage(message)
        }
    }
}
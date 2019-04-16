package dimi.com.jetpack.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import dimi.com.jetpack.JetpackApp
import dimi.com.jetpack.R
import dimi.com.jetpack.data.entity.MessageEntity
import dimi.com.jetpack.ui.main.adapter.MessageAdapter
import dimi.com.jetpack.ui.main.viewmodel.MessageVM
import kotlinx.android.synthetic.main.message_list_fragment.*
import java.util.*

class MessageListFragment : Fragment() {

    private lateinit var messageVm: MessageVM
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageVm = ViewModelProviders.of(this).get(MessageVM::class.java)
        JetpackApp.appComponent.inject(messageVm)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.message_list_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageAdapter = MessageAdapter(context)
        locationList.layoutManager = LinearLayoutManager(activity)
        locationList.adapter = messageAdapter
        messageAdapter.notifyDataSetChanged()
        messageVm.getAllMessages().observe(this, Observer { messages ->
            Log.e("SIZE", messages.size.toString())
            messageAdapter.updateData(messages)
        })

        add.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.addMessageFragment)
            //messageVm.addMessage(MessageEntity(0, "HELLO", Date(), null))
        }
    }
}
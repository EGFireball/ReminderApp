package dimi.com.jetpack.ui.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dimi.com.jetpack.R
import dimi.com.jetpack.data.entity.MessageEntity
import kotlinx.android.synthetic.main.message_item.view.*
import java.text.SimpleDateFormat

class MessageAdapter(val context: Context?): RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    private var items: List<MessageEntity> = mutableListOf()

    @SuppressLint("SimpleDateFormat")
    val formatter = SimpleDateFormat("dd-MM-yyyy")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.message_item, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = items[position]
        holder.message.text = message.message
        holder.created.text = formatter.format(message.created)
        if (message.remindMe != null) {
            holder.remindMe.text = formatter.format(message.remindMe)
        }
    }

    fun updateData(messages: List<MessageEntity>) {
        this.items = messages
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val message: TextView = itemView.message
        val created: TextView = itemView.created
        val remindMe: TextView = itemView.remindMe
    }
}
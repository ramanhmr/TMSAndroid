package com.ramanhmr.tmsandroid.homework16

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramanhmr.tmsandroid.databinding.ItemMessageBinding

class MessageAdapter(
    private var messages: MutableList<Message>,
    private val onLongClickAction: (Message) -> Unit
) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder =
        MessageViewHolder(
            ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onLongClickAction
        )

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount(): Int = messages.size

    fun update(newMessages: List<Message>) {
        messages.clear()
        messages.addAll(newMessages)
        notifyDataSetChanged()
    }

    class MessageViewHolder(
        val binding: ItemMessageBinding,
        val onLongClickAction: (Message) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.tvMessage.text = message.text
            binding.tvAddTime.text = message.time
            binding.root.setOnLongClickListener {
                onLongClickAction(message)
                true
            }
        }
    }
}
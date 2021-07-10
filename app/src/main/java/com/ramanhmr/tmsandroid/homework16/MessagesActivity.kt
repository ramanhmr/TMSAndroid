package com.ramanhmr.tmsandroid.homework16

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramanhmr.tmsandroid.HomeworkApp
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.ActivityMessagesBinding
import com.ramanhmr.tmsandroid.homework16.database.MessageRepository

class MessagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessagesBinding
    private val viewModel: MessagesViewModel by viewModels {
        MessagesViewModelFactory(
            MessageRepository((application as HomeworkApp).messageDao)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        ResourcesCompat.getDrawable(resources, R.drawable.divider_black, null)
            ?.let { dividerItemDecoration.setDrawable(it) }
        binding.rvMessages.addItemDecoration(dividerItemDecoration)
        binding.rvMessages.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = MessageAdapter(
            mutableListOf(),
            { message -> viewModel.deleteMessageFromDatabase(message) })
        binding.rvMessages.adapter = adapter
        viewModel.messagesLiveData.observe(this, { adapter.update(it) })

        binding.btnAdd.setOnClickListener {
            with(binding.etMessage) {
                viewModel.addMessageToDatabase(text.toString())
                setText("")
            }
        }
    }
}
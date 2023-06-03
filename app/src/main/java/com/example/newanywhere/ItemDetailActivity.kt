package com.example.newanywhere

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newanywhere.databinding.ActivityItemDetailBinding

class ItemDetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: itemDetailViewModel
    val binding by lazy { ActivityItemDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        detailViewModel = ViewModelProvider(this).get(itemDetailViewModel::class.java)


        val id = intent.getStringExtra("itemId")
        binding.itemIdTextView.text=id
    }
}
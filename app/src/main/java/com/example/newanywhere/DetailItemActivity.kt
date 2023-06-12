package com.example.newanywhere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.newanywhere.Retrofit.Detail
import com.example.newanywhere.Retrofit.DetailItem
import com.example.newanywhere.databinding.ActivityItemDetailBinding
import com.example.newanywhere.databinding.ActivityMainBinding
import com.example.newanywhere.ui.home.HomeViewModel

class DetailItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailBinding
    private lateinit var vm: DetailItemViewModel
    lateinit var actionBar : ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemId = intent.getStringExtra("itemId")


        binding.toolbarLayout.setExpandedTitleTextAppearance(R.style.ToolbarTitleStyle_Dark)
        binding.toolbarLayout.setCollapsedTitleTextAppearance(R.style.ToolbarTitleStyle_Dark)


        vm = ViewModelProvider(this).get(DetailItemViewModel::class.java)

        if (itemId != null) {
            vm.refresh(itemId)
        }
        observe()

//        actionBar!!.title = itemId

    }

    private fun observe() {
        vm.data.observe(this, Observer {
            binding.toolbarLayout.title = it.title
            Glide.with(this).load(it.firstimage)
                .placeholder(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(binding.itemImage)
            binding.itemImage
        })
    }
}
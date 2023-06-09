package com.example.newanywhere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        actionBar= supportActionBar!!
        val itemId = intent.getStringExtra("itemId")

        vm = ViewModelProvider(this).get(DetailItemViewModel::class.java)

        if (itemId != null) {
            vm.refresh(itemId)
        }
        observe()
//        actionBar!!.title = itemId

    }

    private fun observe() {
        vm.data.observe(this, Observer {
            actionBar!!.title = it.title
        })
    }
}
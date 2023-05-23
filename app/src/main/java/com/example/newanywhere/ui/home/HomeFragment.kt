package com.example.newanywhere.ui.home

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.view.marginRight
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newanywhere.R
import com.example.newanywhere.Retrofit.AreaCode
import com.example.newanywhere.Retrofit.Item
import com.example.newanywhere.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel :HomeViewModel
    var areaCodeNum = 0
    var area = ArrayList<Item>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.Arearefresh()
        observeAreaCodeNum()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun observeAreaCodeNum(){
        homeViewModel.AreaCodedata.observe(viewLifecycleOwner, Observer {
            areaCodeNum = it.response.body.totalCount
            area.addAll(it.response.body.items.item)
            //버튼 생성
            for(i in 0 until areaCodeNum){
                setRegionButton(i)
            }
        })
    }
    fun setRegionButton( index :Int){

        var btn =  Button(context).apply {
            val lp = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            lp.setMargins(10, 5, 10, 5)

            layoutParams = lp
            background = getDrawable(context,R.drawable.area_button)
            text = area.get(index).name
            setOnClickListener {
                Log.d("HomeFragment","setRegionButton : ${area.get(index)}")
            }
        }
        btn.setPadding(10,0,10,0)
        binding.linearLayInHScroll.addView(btn)
    }
    fun getDPI(dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics)
            .toInt()
    }
}
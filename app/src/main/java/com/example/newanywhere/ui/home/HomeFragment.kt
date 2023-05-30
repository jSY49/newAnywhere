package com.example.newanywhere.ui.home

import android.annotation.SuppressLint
import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newanywhere.R
import com.example.newanywhere.Retrofit.Item
import com.example.newanywhere.Retrofit.listItem
import com.example.newanywhere.databinding.FragmentHomeBinding
import com.example.newanywhere.itemAdapater
import com.example.newanywhere.progressDialog

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel
    var areaCodeNum = 0
    var area = ArrayList<Item>()
    var list = ArrayList<listItem>()
    var clickedAreaId = 1
    private var myItemAdpater = itemAdapater(arrayListOf())
    lateinit var dialog : progressDialog
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        dialog = context?.let { progressDialog(it) } !!

        dialog.show()
        setRecyclerView()   //adapter 등록
        homeViewModel.refresh(0, 0)  //id=0 , 지역코드 가져오기
        observe()    //데이터observe

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setRecyclerView() {
        binding.itemRecyclerview.layoutManager

        binding.itemRecyclerview.apply {
            layoutManager = LinearLayoutManager(context).also {
                it.orientation = LinearLayoutManager.VERTICAL
            }
            adapter = myItemAdpater
        }
    }

    fun observe() {
        homeViewModel.AreaCodedata.observe(viewLifecycleOwner, Observer {
            areaCodeNum = it.response.body.totalCount   //총 지역 수
            area.addAll(it.response.body.items.item)    //list에 추가
            //버튼 생성
            for (i in 0 until areaCodeNum) {
                setRegionButton(i)
            }
            binding.RadioInHScroll.check(clickedAreaId) //현재 선택 라디오 check
            homeViewModel.refresh(
                clickedAreaId,
                it.response.body.items.item.get(0).code.toInt()
            )  //처음 데이터 가져오기
        })

        homeViewModel.TourData.observe(viewLifecycleOwner, Observer {
            //리사이클러뷰 데이터 세팅 해주기
            setRecycler(it)
            dialog.dismiss()
        })
    }

    @SuppressLint("SetTextI18n")
    fun setRegionButton(index: Int) {

        val btn = RadioButton(context).apply {
            val lp = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            lp.setMargins(10, 5, 10, 5)
            layoutParams = lp
            background = getDrawable(context, R.drawable.radio_select)
            text = "#${area[index].name}"
            setOnClickListener {
                Log.d("HomeFragment","setRegionButton : ${area[index]}")

                dialog.show()

                list.clear()
                homeViewModel.refresh(area[index].code.toInt(), 1)
            }
        }
        btn.buttonDrawable = StateListDrawable() // radio button 에서 원을 삭제하기.
        btn.setPadding(25, 15, 25, 15)
        binding.RadioInHScroll.addView(btn)

        if (index == 0) {
            clickedAreaId = btn.id
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setRecycler(it: List<listItem>) {
        list.addAll(it)
        myItemAdpater.updateitems(list)
        myItemAdpater.notifyDataSetChanged()
    }
}
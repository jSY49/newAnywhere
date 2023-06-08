package com.example.newanywhere

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newanywhere.Retrofit.listItem
import com.example.newanywhere.databinding.ItemLayoutBinding


class itemAdapater(private var data: ArrayList<listItem>) :
    RecyclerView.Adapter<itemAdapater.MyViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateitems(newitems: List<listItem>) {
        data.clear()
        data.addAll(newitems)
        notifyDataSetChanged()
    }

    // 생성된 뷰 홀더에 값 지정
    inner class MyViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context

        fun bind(currentitem: listItem) {

            binding.itemTitleTextview.text=currentitem.title
            binding.itemAddrTextview.text=currentitem.addr1
            Glide.with(context).load(currentitem.firstimage)
                .placeholder(R.drawable.ic_launcher_foreground)
                .centerCrop()
//                .apply(RequestOptions.bitmapTransform(RoundedCorners(15)))
                .into(binding.imageView)

            itemView.setOnClickListener{
                val intent = Intent(context, DetailItemActivity::class.java)
                intent.putExtra("itemId",currentitem.contentid)
                intent.run{
                    context.startActivity(this)
                }

            }

        }
    }

    // 어떤 xml 으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //val binding = RecycleritemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //여기~!
        val item = data
        if (item != null) {
            holder.bind(item.get(position))
        }
    }


    // 뷰 홀더의 개수 리턴
    override fun getItemCount(): Int {
        return data.size
    }


}
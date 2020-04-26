package com.example.stickerview.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.example.stickerview.Common.Common
import com.example.stickerview.Interface.IOnAlphabetItemClickListener
import com.example.stickerview.R
import kotlinx.android.synthetic.main.alphabet_item.view.*

class AlphabetAdapter : RecyclerView.Adapter<AlphabetAdapter.MyViewHolder>() {

    internal var alphabetList:List<String>
    internal lateinit var iOnAlphabetItemClick: IOnAlphabetItemClickListener

    init {
        alphabetList = Common.genAlphabetLIst()
    }

    fun setAlphabetClick(iOnAlphabetItemClickListener: IOnAlphabetItemClickListener){
      iOnAlphabetItemClick = iOnAlphabetItemClickListener
    }
    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        internal var alphabet_img: ImageView
        init{
            alphabet_img = itemView.findViewById(R.id.alphabet_item) as ImageView
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
      val itemView = LayoutInflater.from(p0.context).inflate(R.layout.alphabet_item,p0,false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return  alphabetList.size

    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val drawable:TextDrawable
        val available_position = Common.alphabet_available.indexOf(alphabetList[p1])
        if(available_position != -1 ){
            drawable = TextDrawable.builder().buildRound(alphabetList[p1], Color.GREEN)
        }
        else{
            drawable = TextDrawable.builder().buildRound(alphabetList[p1], Color.GRAY)
        }
        p0.alphabet_img.setImageDrawable(drawable)
        p0.itemView.setOnClickListener{
            iOnAlphabetItemClick.onAlphabetItemClick(alphabetList[p1],available_position)
        }

    }

}
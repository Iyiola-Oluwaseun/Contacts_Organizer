package com.example.stickerview.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.example.stickerview.AlphabetActvity
import com.example.stickerview.Common.Common
import com.example.stickerview.Model.Person
import com.example.stickerview.R

class PersonAdapter(internal  var context: Context,
                    internal var personList:List<Person>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    internal  inner class GroupViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var text_group_title:TextView
        init{
            text_group_title = itemView.findViewById(R.id.text_group_title) as TextView

        }
    }
    internal  inner class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var person_name:TextView
        var person_position:TextView
        var person_avatar:ImageView
        init{
            person_name = itemView.findViewById(R.id.person_name) as TextView
            person_position = itemView.findViewById(R.id.person_position) as TextView
            person_avatar = itemView.findViewById(R.id.person_avatar) as ImageView


        }
    }

    override fun getItemViewType(position: Int): Int {
        return personList.get(position).viewType
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        when(viewType){
            Common.VIEWTYPE_GROUP -> {
                val group = inflater.inflate(R.layout.group_layout,viewGroup,false) as ViewGroup
                return GroupViewHolder(group)
            }
            Common.VIEWTYPE_PERSONS -> {
                val personLayout = inflater.inflate(R.layout.person_layout,viewGroup,false) as ViewGroup
                return PersonViewHolder(personLayout)


            }
            else ->{
                val group = inflater.inflate(R.layout.group_layout,viewGroup,false) as ViewGroup
                return GroupViewHolder(group)

            }
        }
    }

    override fun getItemCount(): Int {
        return personList.size

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if(viewHolder is GroupViewHolder)
        {
            viewHolder.text_group_title.text = personList[position].name
            viewHolder.itemView.setOnClickListener{
                (context as Activity).startActivityForResult(Intent(context, AlphabetActvity::class.java),Common.RESULT_CODE)
            }
        }
        else if(viewHolder is PersonViewHolder){
            viewHolder.person_name.text = personList[position].name
            viewHolder.person_position.text = personList[position].position
            val generator =  ColorGenerator.MATERIAL
            val drawable = TextDrawable.builder().buildRound(personList[position].name!![0].toString(),generator.randomColor)
            viewHolder.person_avatar.setImageDrawable(drawable)
            viewHolder.itemView.setOnClickListener {
                Toast.makeText(context,""+personList[position].name,Toast.LENGTH_SHORT).show()

            }

        }

    }

}
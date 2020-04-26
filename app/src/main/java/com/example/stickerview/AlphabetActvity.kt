package com.example.stickerview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stickerview.Adapter.AlphabetAdapter
import com.example.stickerview.Interface.IOnAlphabetItemClickListener
import kotlinx.android.synthetic.main.activity_alphabet_actvity.*
import kotlinx.android.synthetic.main.activity_main.*

class AlphabetActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_actvity)

        val alphabetAdapter = AlphabetAdapter()
        alphabetAdapter.setAlphabetClick(object: IOnAlphabetItemClickListener{
            override fun onAlphabetItemClick(value: String, position: Int) {
                if(position != -1){
                    val returnIntent = Intent()
                    returnIntent.putExtra("result",value)
                    setResult(Activity.RESULT_OK,returnIntent)
                    finish()
                }


            }
        })

        recycler_alphabet.layoutManager = GridLayoutManager(this,4)
        recycler_alphabet.adapter = alphabetAdapter

    }
}


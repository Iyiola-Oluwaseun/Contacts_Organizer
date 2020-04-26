package com.example.stickerview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stickerview.Adapter.PersonAdapter
import com.example.stickerview.Common.Common
import com.example.stickerview.Common.LinearLayoutManagerWithSmoothScroller
import com.example.stickerview.Model.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal var personList = ArrayList<Person>()
    internal lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManagerWithSmoothScroller(this)

        recycler_person.layoutManager = layoutManager
        recycler_person.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))

        createPersonList()
        val adapter = PersonAdapter(this,personList)
        recycler_person.adapter = adapter
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Common.RESULT_CODE)
        {
            if(resultCode == Activity.RESULT_OK){
                val result = data!!.getStringExtra("result")
                val position = Common.findPositionWithName(result,personList)
                recycler_person.smoothScrollToPosition(position)

            }
        }
    }
    private fun createPersonList() {
        personList = Common.geNPersonGrojup()
        personList = Common.sortList(personList)
        personList = Common.addAlphabet(personList)
    }
}

package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.sql.Time
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var elements: MutableList<RowData>
    lateinit var createBtn: Button
    lateinit var myAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)

        elements = mutableListOf(RowData(R.drawable.user1, "Artur Zaqaryan", "022-22-22-22", "class", Date(2021,2,15), Time(16, 20, 0)),
            RowData(R.drawable.user5, "Vardan Hakobyan", "011-11-11-11", "class", Date(2020,2,15), Time(17,35,0)),
            RowData(R.drawable.user2, "Shirak Grigoryan", "044-44-44-44", "class", Date(2019,2,15), Time(22,12,0)),
            RowData(R.drawable.user3, "Lyov Sardaryan", "055-55-55-55", "family", Date(2020,2,15), Time(0, 15,0)),
            RowData(R.drawable.user4, "Aram Sharoyan", "066-66-66-66", "family", Date(2020,2,15), Time(14,20,0)),
            RowData(R.drawable.user5, "Vardan Hakobyan", "011-11-11-11", "family", Date(2020,2,15), Time(11,2,0)),
            RowData(R.drawable.user2, "Shirak Grigoryan", "044-44-44-44", "neighbour", Date(2020,2,15), Time(22,22,0)),
            RowData(R.drawable.user3, "Lyov Sardaryan", "055-55-55-55", "neighbour", Date(2018,2,15), Time(7,59,0)),
            RowData(R.drawable.user4, "Aram Sharoyan", "066-66-66-66", "neighbor", Date(2019,2,15), Time(0,0,0)))

        myAdapter = RecyclerAdapter(this, elements)

        recycler.adapter = myAdapter
        recycler.layoutManager = LinearLayoutManager(this)

        createBtn = findViewById(R.id.create_btn)

        createBtn.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var newContact: RowData
        if(requestCode == 1){
            if(resultCode == 1){
                val con = data?.getSerializableExtra("contact")
                if(con != null){
                    newContact = con as RowData
                    elements.add(newContact)
                    myAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    fun clickHandler(view: View){
        if(view is ConstraintLayout){
            val btn = view.findViewById<Button>(R.id.remove_btn)
            if(btn.visibility == View.GONE) {
                val pos = view.findViewById<TextView>(R.id.position).text.toString().toInt()
                var intent = Intent(this, InfoActivity::class.java).apply {
                    putExtra("data", elements[pos])
                }
                startActivity(intent)
            }
            else{
                btn.visibility = View.GONE
            }
        }
    }
}
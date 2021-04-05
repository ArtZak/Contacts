package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.Serializable
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class InfoActivity : AppCompatActivity() {
    lateinit var row: RowData
    lateinit var group: TextView
    lateinit var lastCallDate: TextView
    lateinit var lastCallTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        row = intent.getSerializableExtra("data") as RowData
        group = findViewById<TextView>(R.id.group)
        lastCallDate = findViewById<TextView>(R.id.last_call_date)
        lastCallTime = findViewById<TextView>(R.id.last_call_time)

        val newDate = Date(row.lastCallDate.year - 1900, row.lastCallDate.month, row.lastCallDate.day)

        group.text = row.group

        var pattern = "dd-MMMM-yyyy"
        val simpleDateFormat = SimpleDateFormat(pattern)
        var formattedDate = simpleDateFormat.format(newDate)

        lastCallDate.text = formattedDate.toString()
        lastCallTime.text = row.lastCallTime.toString()
    }
}
package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.sql.Time
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class CreateActivity : AppCompatActivity() {
    lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        submitBtn = findViewById(R.id.submit)

        submitBtn.setOnClickListener {
            val name = findViewById<EditText>(R.id.name).text.toString()
            val phone = findViewById<EditText>(R.id.phone).text.toString()
            val group = findViewById<EditText>(R.id.group).text.toString()
            val date = Date(LocalDateTime.now().year, LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth)
            val time = Time(LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)

            val contact = RowData(R.drawable.user1, name, phone, group, date, time)

            var intent = Intent(this, MainActivity::class.java).apply {
                putExtra("contact", contact)
            }
            setResult(1, intent)
            finish()
        }
    }
}
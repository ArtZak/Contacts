package com.example.contacts

import java.io.Serializable
import java.sql.Time
import java.util.*

data class RowData(val icon: Int,
                   val name: String,
                   val phone: String,
                   val group: String,
                   val lastCallDate: Date,
                   val lastCallTime: Time) : Serializable

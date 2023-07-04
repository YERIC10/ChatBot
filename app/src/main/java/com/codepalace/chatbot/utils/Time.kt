package com.codepalace.chatbot.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


object Time {
    fun timeStamp(): String {
        val timeStamp =
            Timestamp(System.currentTimeMillis())
        val sdf = SimpleDateFormat("HH:mm")
        return sdf.format(Date(timeStamp.time))
    }
}

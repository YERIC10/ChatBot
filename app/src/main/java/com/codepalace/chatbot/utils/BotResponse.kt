package com.codepalace.chatbot.utils

import com.codepalace.chatbot.utils.Constants.OPEN_GOOGLE
import com.codepalace.chatbot.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {


            //hola
            message.contains("hola") -> {
                when (random) {
                    0 -> "Hola. Necesitas Ayuda?"
                    1 -> "Hola. Platicame tu problema"
                    else -> "Buen dia!, estoy para ayudarte"}
            }


            message.contains("no escanea el qr") -> {
                when (random) {
                    else -> "Te brindamos estas posibles soluciones: \n\n" +
                     "1. Asegurate que la camara enfoque bien el Qr\n"+
                     "2. Conectate a Internet\n" +
                     "3. Conectate a un red Wifi, para tener mejor conexion\n\n" +
                     "Espermos que hallamos resuelto tu problema."
                }
            }

            message.contains("no funciono") -> {
                when (random) {
                    0 -> "Estamos teneindo problemas con el servidor.\n" +
                            "por favor dejano tu comentario en la caja de sugerencia."
                    1 ->  "Estamos en mantenimiento del servidor, lo sentimos mucho" +
                            "por favor dejano tu comentario en la caja de sugerencia."

                    else -> "Lo siento, estamos teniendo problemas con el servidor"
                }
            }

            message.contains("gracias") -> {
                when (random) {
                    0 -> "Me alegra de haberte ayudado. \n" +
                            "Dejanos tu comentario en la caja de sugerencia.\n" +
                            "Nos sirve para mejorar nuestro aplicativo"

                    1 ->  "Gracias por contar con nosotro." +
                            "Dejanos tu comentario en la caja de sugerencia.\n" +
                            "Nos sirve para mejorar nuestro aplicativo"

                    else -> "Gracias.\n" +
                            "Esperemos mejorar con sus sugerencia"
                }
            }

            message.contains("no carga las imagenes") -> {
                when (random) {
                    else -> "Te brindamos estas posibles soluciones: \n\n"+
                            "1. Asegurate de tener una buena conexion a Internet\n" +
                            "2. Conectate a un red Wifi, para tener mejor conexion\n\n" +
                            "Espermos que hallamos resuelto tu problema."
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "No Entiendo..."
                    1 -> "Intenta preguntarme algo diferente"
                    2 -> "Lo siento, no puedo resolver eso."
                    else -> ("No Entiendo...")
                }
            }
        }
    }
}
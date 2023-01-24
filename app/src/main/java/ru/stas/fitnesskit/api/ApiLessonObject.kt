package ru.stas.fitnesskit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiLessonObject {

        private var BASE_URL = "https://olimpia.fitnesskit-admin.ru"

        fun getInstance() : Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }
    }
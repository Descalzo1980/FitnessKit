package ru.stas.fitnesskit.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.stas.fitnesskit.data.models.Lesson

interface ApiLessonInterface {

    @GET("schedule/get_v3/{club_id}")
    fun getAllLessons(@Path("club_id") clubId: Int): Response<Lesson>
}
package ru.stas.fitnesskit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.stas.fitnesskit.api.ApiLessonInterface
import ru.stas.fitnesskit.data.models.DataLessons
import ru.stas.fitnesskit.data.models.Lesson
import ru.stas.fitnesskit.data.models.Trainer

class LessonsRepository(private val apiLessonsInterface: ApiLessonInterface) {

    private val lessonsLiveData = MutableLiveData<Lesson>()

    val lessons: LiveData<Lesson>
        get() = lessonsLiveData

    fun getLessons(){
        val result = apiLessonsInterface.getAllLessons(clubId = 2)
        if (result.body() != null){
            lessonsLiveData.postValue(result.body())
        }
    }
}
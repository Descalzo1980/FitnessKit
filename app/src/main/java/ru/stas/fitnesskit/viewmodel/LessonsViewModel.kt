package ru.stas.fitnesskit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.stas.fitnesskit.data.models.DataLessons
import ru.stas.fitnesskit.data.models.Lesson
import ru.stas.fitnesskit.data.models.Trainer
import ru.stas.fitnesskit.repository.LessonsRepository

class LessonsViewModel(private val lessonsRepository: LessonsRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            lessonsRepository.getLessons()
        }
    }

    val lessons : LiveData<Lesson>
        get() = lessonsRepository.lessons
}



package ru.stas.fitnesskit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.stas.fitnesskit.repository.LessonsRepository

class LessonsViewModelFactory(private val lessonsRepository: LessonsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LessonsViewModel(lessonsRepository) as T
    }
}
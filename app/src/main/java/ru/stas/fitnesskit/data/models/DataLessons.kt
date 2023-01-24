package ru.stas.fitnesskit.data.models

data class DataLessons(
    val lessons: List<Lesson>,
    val option: Option,
    val tabs: List<Tab>,
    val trainers: List<Trainer>
)
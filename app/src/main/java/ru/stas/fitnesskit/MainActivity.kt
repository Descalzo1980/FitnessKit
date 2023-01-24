package ru.stas.fitnesskit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.stas.fitnesskit.api.ApiLessonInterface
import ru.stas.fitnesskit.api.ApiLessonObject
import ru.stas.fitnesskit.data.models.Lesson
import ru.stas.fitnesskit.databinding.ActivityMainBinding
import ru.stas.fitnesskit.repository.LessonsRepository
import ru.stas.fitnesskit.viewmodel.LessonsViewModel
import ru.stas.fitnesskit.viewmodel.LessonsViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var lessonsViewModel: LessonsViewModel

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lessonsItem = listOf<Lesson>()
        val adapter = LessonsListAdapter(lessonsItem)
        binding.lessonsGrid.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        binding.lessonsGrid.layoutManager = layoutManager

        val apiInterface = ApiLessonObject.getInstance().create(ApiLessonInterface::class.java)

        val lessonsRepository = LessonsRepository(apiInterface)

        lessonsViewModel = ViewModelProvider(
            this,
            LessonsViewModelFactory(lessonsRepository)
        )[LessonsViewModel::class.java]

//        lessonsViewModel.lessons.observe(this) { lessons ->
//            Log.d("MyTag", "onCreate: ${lessons.description}")
//        }
        GlobalScope.launch(Dispatchers.Main) {
            val response = apiInterface.getAllLessons(clubId = 2)
            if (response.isSuccessful) {
                binding.lessonsGrid.adapter = adapter
            }
        }
    }
}
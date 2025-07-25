package com.example.hm2.utils

import com.example.hm2.data.Model
object ModelGenerator {
    fun generateModels(count: Int, imageResIds: List<Int>): List<Model> {
        val models = mutableListOf<Model>()
        for (i in 1..count) {
            val title = "Заголовок $i"
            val description = "Описание $i"
            val imageResId = imageResIds.random()
            models.add(Model(imageResId, title, description))
        }
        return models
    }
}

package com.example.hm2.ui.adapter

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hm2.R

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView: ImageView = findViewById(R.id.detailImageView)
        val titleTextView: TextView = findViewById(R.id.detailTitleView)
        val descriptionTextView: TextView = findViewById(R.id.detailDescriptionView)

        intent?.let {
            val title = it.getStringExtra("title") ?: "Нет заголовка"
            val description = it.getStringExtra("description") ?: "Нет описания"
            val imageResId = it.getIntExtra("imageResId", R.drawable.image1)

            with(imageView) {
                setImageResource(imageResId)
            }
            titleTextView.text = title
            descriptionTextView.text = description
        }
    }
}

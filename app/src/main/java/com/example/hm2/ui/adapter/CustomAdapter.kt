package com.example.hm2.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hm2.R
import com.example.hm2.data.Model

class CustomAdapter(
    private var models: MutableList<Model>,
    private val imageResIds: List<Int>
) : RecyclerView.Adapter<CustomAdapter.ModelViewHolder>() {

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleView: TextView = itemView.findViewById(R.id.titleView)
        val descriptionView: TextView = itemView.findViewById(R.id.descriptionView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val currentModel = models[position]

        with(holder) {
            imageView.setImageResource(currentModel.imageResId)
            titleView.text = currentModel.title
            descriptionView.text = currentModel.description

            itemView.setOnClickListener {
                val context = itemView.context
                Intent(context, InfoActivity::class.java).also {
                    it.putExtra("title", currentModel.title)
                    it.putExtra("description", currentModel.description)
                    it.putExtra("imageResId", currentModel.imageResId)
                    context.startActivity(it)
                }
            }

            imageView.setOnClickListener {
                val newImageResId = imageResIds.random()
                val updatedModel = currentModel.copy(imageResId = newImageResId)
                models[position] = updatedModel
                imageView.setImageResource(newImageResId)
            }
        }
    }

    override fun getItemCount(): Int = models.size
}

package com.example.lab_week_06.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.ImageLoader
import com.example.lab_week_06.R
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

private const val FEMALE_SYMBOL = "♀"
private const val MALE_SYMBOL = "♂"
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(containerView) {

    private val catBiographyView = containerView.findViewById<TextView>(R.id.cat_biography)
    private val catBreedView = containerView.findViewById<TextView>(R.id.cat_breed)
    private val catGenderView = containerView.findViewById<TextView>(R.id.cat_gender)
    private val catNameView = containerView.findViewById<TextView>(R.id.cat_name)
    private val catPhotoView = containerView.findViewById<ImageView>(R.id.cat_photo)

    fun bindData(cat: CatModel) {
        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = cat.breed.name
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
}

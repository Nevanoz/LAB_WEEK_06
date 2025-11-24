package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.adapter.CatAdapter
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    private val catAdapter by lazy {
        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatAdapter.OnClickListener {
                override fun onItemClick(cat: CatModel) {
                    showSelectionDialog(cat)
                }
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = catAdapter

        catAdapter.setData(generateCats())
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You selected ${cat.name}")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun generateCats(): List<CatModel> {
        return listOf(
            CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent killer", "https://cdn2.thecatapi.com/images/7dj.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cute assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
            CatModel(Gender.Unknown, CatBreed.AmericanCurl, "George", "Detective cat", "https://cdn2.thecatapi.com/images/bar.jpg"),
            CatModel(Gender.Male, CatBreed.AmericanCurl, "Leo", "Calm", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair, "Luna", "Sweet", "https://cdn2.thecatapi.com/images/MTY3ODIyMg.jpg"),
            CatModel(Gender.Male, CatBreed.BalineseJavanese, "Max", "Playful", "https://cdn2.thecatapi.com/images/MTY3ODIyMw.jpg"),
            CatModel(Gender.Female, CatBreed.AmericanCurl, "Mimi", "Lazy", "https://cdn2.thecatapi.com/images/MTY3ODIyNA.jpg"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair, "Oscar", "Curious", "https://cdn2.thecatapi.com/images/MTY3ODIyNQ.jpg"),
            CatModel(Gender.Unknown, CatBreed.BalineseJavanese, "Snow", "Quiet", "https://cdn2.thecatapi.com/images/MTY3ODIyNg.jpg"),
            CatModel(Gender.Female, CatBreed.AmericanCurl, "Bella", "Friendly", "https://cdn2.thecatapi.com/images/MTY3ODIyNw.jpg")
        )
    }
}

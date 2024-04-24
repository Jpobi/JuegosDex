package com.example.juegosdex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.constraintlayout.widget.ConstraintSet.WRAP_CONTENT
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var name: TextView
    private lateinit var rating :TextView
    private lateinit var release : TextView
    private lateinit var description : TextView
    private lateinit var logo : ImageView
    private lateinit var genreImg: ImageView

    private var ratingCount=0
    private lateinit var starImg: ImageView
    private lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        name=findViewById(R.id.detail_title)
        rating=findViewById(R.id.detail_rating)
        release=findViewById(R.id.detail_release)
        description=findViewById(R.id.detail_description)
        logo=findViewById(R.id.detailImg)
        genreImg=findViewById(R.id.detail_genre)

        val game: Game? = getIntent().getSerializableExtra("game") as? Game

        name.text=game?.name
        rating.text=game?.rating.toString()
        release.text=game?.year.toString()
        description.text=game?.description.toString()

        Glide.with(this)
            .load(game?.logoUrl)
            .into(logo)

        val image = when(game?.genre) {
            Genre.ADVENTURE -> R.drawable.adventure
            Genre.FPS -> R.drawable.fps
            Genre.ARCADE -> R.drawable.arcade
            Genre.PUZZLE -> R.drawable.puzzle
            Genre.ROGUELIKE -> R.drawable.roguelike
            Genre.SANDBOX -> R.drawable.sandbox
            else->R.drawable.arcade
        }
        genreImg.setImageResource(image)


        var ratingCount = game?.rating ?: 0
        var leftId = R.id.detail_genre
        var marginLeft = 100

        val constraintLayout = findViewById<ConstraintLayout>(R.id.detail_constraint_layout)

        while (ratingCount > 0) {
            val starImg = ImageView(applicationContext)
            starImg.id = View.generateViewId()
            starImg.setImageResource(R.drawable.star)

            val starLayoutParams = ConstraintLayout.LayoutParams(
                60,
                60
            )
            starLayoutParams.topToBottom = R.id.detail_rating_title
            starLayoutParams.topMargin = 8
            starLayoutParams.leftToRight = leftId
            starLayoutParams.marginStart = marginLeft

            constraintLayout.addView(starImg, starLayoutParams)

            val constraintSet = ConstraintSet()
            constraintSet.clone(constraintLayout)
            constraintSet.connect(
                starImg.id,
                ConstraintSet.START,
                leftId,
                ConstraintSet.END,
                marginLeft
            )
            constraintSet.connect(
                starImg.id,
                ConstraintSet.TOP,
                R.id.detail_title,
                ConstraintSet.BOTTOM,
                8
            )
            constraintSet.applyTo(constraintLayout)

            ratingCount--
            leftId = starImg.id
            marginLeft = 4
        }
    }
}
package com.example.juegosdex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.Serializable

class Adapter(val context: Context) : ListAdapter<Game, Adapter.ViewHolder>(DiffCallBack){
    lateinit var onItemClickListener : (Game) -> Unit
    inner class ViewHolder(private val view: View) :RecyclerView.ViewHolder(view){
        val nombreElem: TextView = view.findViewById(R.id.name)
        val imageElem: ImageView = view.findViewById(R.id.gameLogo)
        val yearElem: TextView = view.findViewById(R.id.year)
        val ratingElem: TextView = view.findViewById(R.id.rating)
        val genreElem: ImageView = view.findViewById(R.id.genreImg)

        fun bind (game: Game) {
            nombreElem.text=game.name
            yearElem.text=game.year.toString()
            ratingElem.text=game.rating.toString()

            Glide.with(context)
                .load(game.logoUrl)
                .into(imageElem)

            val image = when(game.genre) {
                Genre.ADVENTURE -> R.drawable.adventure
                Genre.FPS -> R.drawable.fps
                Genre.ARCADE -> R.drawable.arcade
                Genre.PUZZLE -> R.drawable.puzzle
                Genre.ROGUELIKE -> R.drawable.roguelike
                Genre.SANDBOX -> R.drawable.sandbox
            }

            genreElem.setImageResource(image)

            view.setOnClickListener{
                onItemClickListener(game)
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem == newItem
        }
    }

}


data class Game(
    val id : Int,
    val name : String,
    val year : Int,
    val rating : Int,
    val genre : Genre,
    val logoUrl : String,
    val description : String
) :Serializable

enum class Genre{
    FPS, PUZZLE,SANDBOX,ROGUELIKE,ADVENTURE, ARCADE
}
package com.example.juegosdex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
private lateinit var recView: RecyclerView
private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView=findViewById(R.id.recView)
        recView.layoutManager= LinearLayoutManager(this)
        adapter=Adapter(applicationContext)
        adapter.submitList(getList())
        recView.adapter=adapter
        adapter.onItemClickListener={
            var intent= Intent(this,DetailActivity::class.java)
            intent.putExtra("game",it)
            startActivity(intent)
        }

    }

    private fun getList(): MutableList<Game>?{
        return mutableListOf(
            Game(
                id=1,
                name="Call of Duty: Modern Warfare",
                year=2019,
                rating=9,
                genre=Genre.FPS,
                logoUrl="https://e7.pngegg.com/pngimages/438/737/png-clipart-call-of-duty-modern-warfare-3-logo-call-of-duty-modern-warfare-3-call-of-duty-4-modern-warfare-call-of-duty-modern-warfare-2-call-of-duty-world-at-war-call-of-duty-pic-label-logo.png",
                description="Fast-paced first-person shooter set in a fictional near-future world. Released in 2011, it continues the gripping narrative established in the previous Modern Warfare games. Players engage in intense combat across various global locations as they confront a Russian ultranationalist threat led by Vladimir Makarov. The game features a compelling single-player campaign, multiplayer modes with customizable loadouts and maps, as well as special ops missions for cooperative play. With its adrenaline-pumping action and cinematic storytelling, Modern Warfare 3 remains a standout title in the Call of Duty franchise"
        ),

        Game(
            id=2,
            name="Portal",
            year=2007,
            rating=10,
            genre=Genre.PUZZLE,
            logoUrl="https://i.pinimg.com/originals/0e/79/c5/0e79c590cd66b6140e9505201045b7de.png",
            description="First-person puzzle game where players must use a portal gun to navigate through chambers."
        ),

        Game(
            id=3,
            name="Minecraft",
            year=2011,
            rating=8,
            genre=Genre.SANDBOX,
            logoUrl="https://static.wikia.nocookie.net/animatorvsanimation/images/5/52/MinecraftIcon.png/revision/latest?cb=20190830150033",
            description="Open world sandbox game with a focus on creativity and exploration. Build anything you can imagine, alone or with friends!"
        ),

        Game(
            id=4,
            name="The Binding of Isaac",
            year=2011,
            rating=8,
            genre=Genre.ROGUELIKE,
            logoUrl="https://w7.pngwing.com/pngs/190/503/png-transparent-the-binding-of-isaac-afterbirth-plus-video-games-mod-biblethump-game-symmetry-head.png",
            description="Roguelike dungeon-crawler with heavy emphasis on random elements. Descend into the depths and battle bizarre enemies!"
        ),

        Game(
            id=5,
            name="The Legend of Zelda: Breath of the Wild",
            year=2017,
            rating=10,
            genre=Genre.ADVENTURE,
            logoUrl="https://static.wikia.nocookie.net/zelda/images/d/d7/Zelda_Breath_of_the_Wild_BotW_Logo.png/revision/latest?cb=20170523125012&path-prefix=es",
            description="Open-air adventure game set in a vast post-apocalyptic world. Explore, solve puzzles, and battle enemies at your own pace!"
        ),

        Game(
            id=6,
            name="Pac-Man",
            year=1980,
            rating=9,
            genre=Genre.ARCADE,
            logoUrl="https://logos-world.net/wp-content/uploads/2023/03/Pac-Man-Logo.png",
            description="Classic arcade game where you control Pac-Man as he navigates a maze eating dots and avoiding ghosts."
        ),
        )
    }
}
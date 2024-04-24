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

    private fun getList(): MutableList<Game>? {
        return mutableListOf(
            Game(
                id = 1,
                name = "Call of Duty: Modern Warfare",
                year = 2019,
                rating = 9,
                genre = Genre.FPS,
                logoUrl = "https://e7.pngegg.com/pngimages/438/737/png-clipart-call-of-duty-modern-warfare-3-logo-call-of-duty-modern-warfare-3-call-of-duty-4-modern-warfare-call-of-duty-modern-warfare-2-call-of-duty-world-at-war-call-of-duty-pic-label-logo.png",
                description = "Fast-paced first-person shooter set in a fictional near-future world. Released in 2011, it continues the gripping narrative established in the previous Modern Warfare games. Players engage in intense combat across various global locations as they confront a Russian ultranationalist threat led by Vladimir Makarov. The game features a compelling single-player campaign, multiplayer modes with customizable loadouts and maps, as well as special ops missions for cooperative play. With its adrenaline-pumping action and cinematic storytelling, Modern Warfare 3 remains a standout title in the Call of Duty franchise"
            ),
            Game(
                id = 2,
                name = "Portal",
                year = 2007,
                rating = 10,
                genre = Genre.PUZZLE,
                logoUrl = "https://i.pinimg.com/originals/0e/79/c5/0e79c590cd66b6140e9505201045b7de.png",
                description = "First-person puzzle game where players must use a portal gun to navigate through chambers."
            ),
            Game(
                id = 3,
                name = "Minecraft",
                year = 2011,
                rating = 8,
                genre = Genre.SANDBOX,
                logoUrl = "https://static.wikia.nocookie.net/animatorvsanimation/images/5/52/MinecraftIcon.png/revision/latest?cb=20190830150033",
                description = "Open world sandbox game with a focus on creativity and exploration. Build anything you can imagine, alone or with friends!"
            ),
            Game(
                id = 4,
                name = "The Binding of Isaac",
                year = 2011,
                rating = 8,
                genre = Genre.ROGUELIKE,
                logoUrl = "https://w7.pngwing.com/pngs/190/503/png-transparent-the-binding-of-isaac-afterbirth-plus-video-games-mod-biblethump-game-symmetry-head.png",
                description = "Roguelike dungeon-crawler with heavy emphasis on random elements. Descend into the depths and battle bizarre enemies!"
            ),
            Game(
                id = 5,
                name = "The Legend of Zelda: Breath of the Wild",
                year = 2017,
                rating = 10,
                genre = Genre.ADVENTURE,
                logoUrl = "https://static.wikia.nocookie.net/zelda/images/d/d7/Zelda_Breath_of_the_Wild_BotW_Logo.png/revision/latest?cb=20170523125012&path-prefix=es",
                description = "Open-air adventure game set in a vast post-apocalyptic world. Explore, solve puzzles, and battle enemies at your own pace!"
            ),
            Game(
                id = 6,
                name = "Pac-Man",
                year = 1980,
                rating = 9,
                genre = Genre.ARCADE,
                logoUrl = "https://logos-world.net/wp-content/uploads/2023/03/Pac-Man-Logo.png",
                description = "Classic arcade game where you control Pac-Man as he navigates a maze eating dots and avoiding ghosts."
            ),
            Game(
                id = 7,
                name = "Fortnite",
                year = 2017,
                rating = 3,
                genre = Genre.FPS,
                logoUrl = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/55b37e64-1594-4afd-8125-74fd8ec48b68/dc5vmno-66ed9f57-5f93-4c8e-b0f0-07a00167fd68.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzU1YjM3ZTY0LTE1OTQtNGFmZC04MTI1LTc0ZmQ4ZWM0OGI2OFwvZGM1dm1uby02NmVkOWY1Ny01ZjkzLTRjOGUtYjBmMC0wN2EwMDE2N2ZkNjgucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.DSkXvOarK5lnc3sceYK6Z-9EM46ymruXyk_0QAtROJY",
                description = "Battle against other players to be the last one standing in this fast-paced, building-focused Battle Royale game."
            ),
            Game(
                id = 8,
                name = "Half-Life 2",
                year = 2004,
                rating = 9,
                genre = Genre.FPS,
                logoUrl = "https://upload.wikimedia.org/wikipedia/en/2/25/Half-Life_2_cover.jpg",
                description = "Sequel to the groundbreaking Half-Life, Half-Life 2 continues the story of Gordon Freeman in a dystopian future where he battles against alien forces."
            ),
            Game(
                id = 9,
                name = "The Witness",
                year = 2016,
                rating = 9,
                genre = Genre.PUZZLE,
                logoUrl = "https://lh3.googleusercontent.com/proxy/vi3nuExWCV0WtgRku0oN6cWiTVMsPTmw1COXmenQB141IfJb-jIR8ztR7soD4lsnyWB_mngnkObVj2Mh8U5Y0kb-qst4QWFE_W6OlgOctQVws1shZIUe",
                description = "Explore a beautiful, mysterious island filled with intricate puzzles that challenge your perception and intellect."
            ),
            Game(
                id = 10,
                name = "Terraria",
                year = 2011,
                rating = 9,
                genre = Genre.SANDBOX,
                logoUrl = "https://cp.beget.com/shared/FAas_qTjBYYvQBYs-ndYKQC368-ok0xD/logo_terraria.png",
                description = "Dig, build, and explore in this 2D sandbox adventure game where you can create your own world and embark on quests."
            ),
            Game(
                id = 11,
                name = "Dead Cells",
                year = 2018,
                rating = 9,
                genre = Genre.ROGUELIKE,
                logoUrl = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/c78bc3fc-9f08-47ca-81ae-d89055c7ec49/dcje0h3-3bea73a1-0ba6-4e64-971b-821b8051ecb2.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2M3OGJjM2ZjLTlmMDgtNDdjYS04MWFlLWQ4OTA1NWM3ZWM0OVwvZGNqZTBoMy0zYmVhNzNhMS0wYmE2LTRlNjQtOTcxYi04MjFiODA1MWVjYjIucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.bza9y5drGUUvzZ6BCCOFeY7v2sByW6okXcAxvZzl5co",
                description = "Action-packed roguelike metroidvania game with challenging combat and procedurally generated levels."
            ),
            Game(
                id = 12,
                name = "The Witcher 3: Wild Hunt",
                year = 2015,
                rating = 10,
                genre = Genre.ADVENTURE,
                logoUrl = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/29e35af4-514b-4267-a51a-3d48afa55ba6/daqy6vm-47b35dd2-16f8-4126-8aa1-a5ba2d3c7487.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzI5ZTM1YWY0LTUxNGItNDI2Ny1hNTFhLTNkNDhhZmE1NWJhNlwvZGFxeTZ2bS00N2IzNWRkMi0xNmY4LTQxMjYtOGFhMS1hNWJhMmQzYzc0ODcucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.RYlHFsx4912jFEt8tzXrH7dMGkspZn4NMrToHgTPdFk",
                description = "Embark on an epic open-world adventure as Geralt of Rivia, a monster hunter, in a richly detailed fantasy world filled with quests, monsters, and political intrigue."
            ),
            Game(
                id = 13,
                name = "Space Invaders",
                year = 1978,
                rating = 8,
                genre = Genre.ARCADE,
                logoUrl = "https://cdn4.iconfinder.com/data/icons/space-32/541/space_41-512.png",
                description = "Classic arcade shooter where you control a spaceship defending against waves of invading aliens."
            )
        )
    }
}
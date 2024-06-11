package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val horoscopeList:List<Horoscope> = listOf(
        Horoscope("aries", "Aries","Mar 21–Apr 19", R.drawable.aries_icon , R.color.Gold),
        Horoscope("aries", "Taurus","Apr 20–May 20", R.drawable.taurus_icon, R.color.purple_700),
        Horoscope("aries", "Gemini","May 21–Jun 21", R.drawable.gemini_icon, R.color.Cornsilk),
        Horoscope("aries", "Cancer","Jun 22–Jul 22", R.drawable.cancer_icon, R.color.Coral),
        Horoscope("aries", "Leo","Jul 23–Aug 22", R.drawable.leo_icon, R.color.DarkOrange),
        Horoscope("aries", "Virgo","Aug 23–Sep 22", R.drawable.virgo_icon, R.color.Ivory),
        Horoscope("aries", "Libra","Sep 23–Oct 23", R.drawable.libra_icon, R.color.teal_200),
        Horoscope("aries", "Scorpio","Oct 24–Nov 21", R.drawable.scorpio_icon, R.color.Chocolate),
        Horoscope("aries", "Sagittarius","Nov 22–Dec 21", R.drawable.sagittarius_icon, R.color.Azure),
        Horoscope("aries", "Capricorn","Dec 22–Jan 19", R.drawable.capricorn_icon, R.color.AliceBlue),
        Horoscope("aries", "Aquarius","Jan 20–Feb 18", R.drawable.aquarius_icon, R.color.PaleTurquoise),
        Horoscope("aries", "Pisces","Feb 19–Mar 20", R.drawable.pisces_icon, R.color.SteelBlue)
    )
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)


            val adapter = HoroscopeAdapter(horoscopeList)
            recyclerView.adapter = adapter
            recyclerView.layoutManager= GridLayoutManager(this, 2)
            //recyclerView.setBackgroundColor(Horoscope.color)




        }
}
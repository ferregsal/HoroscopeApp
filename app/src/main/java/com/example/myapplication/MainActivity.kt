package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val horoscopeList:List<Horoscope> = listOf(
        Horoscope("aries", "Aries","Mar 21–Apr 19", R.drawable.aries_icon),
        Horoscope("aries", "Taurus","Apr 20–May 20", R.drawable.taurus_icon ),
        Horoscope("aries", "Gemini","May 21–Jun 21", R.drawable.gemini_icon),
        Horoscope("aries", "Cancer","Jun 22–Jul 22", R.drawable.cancer_icon),
        Horoscope("aries", "Leo","Jul 23–Aug 22", R.drawable.leo_icon),
        Horoscope("aries", "Virgo","Aug 23–Sep 22", R.drawable.virgo_icon),
        Horoscope("aries", "Libra","Sep 23–Oct 23", R.drawable.libra_icon),
        Horoscope("aries", "Scorpio","Oct 24–Nov 21", R.drawable.scorpio_icon),
        Horoscope("aries", "Sagittarius","Nov 22–Dec 21", R.drawable.sagittarius_icon),
        Horoscope("aries", "Capricorn","Dec 22–Jan 19", R.drawable.capricorn_icon),
        Horoscope("aries", "Aquarius","Jan 20–Feb 18", R.drawable.aquarius_icon),
        Horoscope("aries", "Pisces","Feb 19–Mar 20", R.drawable.pisces_icon)
    )
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)

            val adapter = HoroscopeAdapter(horoscopeList)
            recyclerView.adapter = adapter
            recyclerView.layoutManager= GridLayoutManager(this, 2)




        }
}
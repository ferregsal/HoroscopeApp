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
        Horoscope("aries", "Aries","Mar 21–Apr 19", R.drawable.aries_icon , R.color.gris_perla),
        Horoscope("aries", "Taurus","Apr 20–May 20", R.drawable.taurus_icon, R.color.gris_carbón),
        Horoscope("aries", "Gemini","May 21–Jun 21", R.drawable.gemini_icon, R.color.beige_claro),
        Horoscope("aries", "Cancer","Jun 22–Jul 22", R.drawable.cancer_icon, R.color.coral_suave),
        Horoscope("aries", "Leo","Jul 23–Aug 22", R.drawable.leo_icon, R.color.ocre_dorado),
        Horoscope("aries", "Virgo","Aug 23–Sep 22", R.drawable.virgo_icon, R.color.verde_salvia),
        Horoscope("aries", "Libra","Sep 23–Oct 23", R.drawable.libra_icon, R.color.azul_polvo),
        Horoscope("aries", "Scorpio","Oct 24–Nov 21", R.drawable.scorpio_icon, R.color.granate),
        Horoscope("aries", "Sagittarius","Nov 22–Dec 21", R.drawable.sagittarius_icon, R.color.lila),
        Horoscope("aries", "Capricorn","Dec 22–Jan 19", R.drawable.capricorn_icon, R.color.verde_oliva),
        Horoscope("aries", "Aquarius","Jan 20–Feb 18", R.drawable.aquarius_icon, R.color.azul_acero),
        Horoscope("aries", "Pisces","Feb 19–Mar 20", R.drawable.pisces_icon, R.color.azul_pálido)
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
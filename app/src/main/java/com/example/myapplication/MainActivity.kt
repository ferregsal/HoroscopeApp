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
        Horoscope("aries", R.string.horoscope_name_aries,R.string.horoscope_date_aries, R.drawable.aries_icon , R.color.gris_perla),
        Horoscope("aries", R.string.horoscope_name_taurus,R.string.horoscope_date_taurus, R.drawable.taurus_icon, R.color.gris_carbón),
        Horoscope("aries", R.string.horoscope_name_gemini,R.string.horoscope_date_gemini, R.drawable.gemini_icon, R.color.beige_claro),
        Horoscope("aries", R.string.horoscope_name_cancer,R.string.horoscope_date_cancer, R.drawable.cancer_icon, R.color.coral_suave),
        Horoscope("aries", R.string.horoscope_name_leo,R.string.horoscope_date_leo, R.drawable.leo_icon, R.color.ocre_dorado),
        Horoscope("aries", R.string.horoscope_name_virgo,R.string.horoscope_date_virgo, R.drawable.virgo_icon, R.color.verde_salvia),
        Horoscope("aries", R.string.horoscope_name_libra,R.string.horoscope_date_libra, R.drawable.libra_icon, R.color.azul_polvo),
        Horoscope("aries", R.string.horoscope_name_scorpio,R.string.horoscope_date_scorpio, R.drawable.scorpio_icon, R.color.granate),
        Horoscope("aries", R.string.horoscope_name_sagittarius,R.string.horoscope_date_sagittarius, R.drawable.sagittarius_icon, R.color.lila),
        Horoscope("aries", R.string.horoscope_name_capricorn,R.string.horoscope_date_capricorn, R.drawable.capricorn_icon, R.color.verde_oliva),
        Horoscope("aries", R.string.horoscope_name_aquarius,R.string.horoscope_date_aquarius, R.drawable.aquarius_icon, R.color.azul_acero),
        Horoscope("aries", R.string.horoscope_name_pisces,R.string.horoscope_date_pisces, R.drawable.pisces_icon, R.color.azul_pálido)
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
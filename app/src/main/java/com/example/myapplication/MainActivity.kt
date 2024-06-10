package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    val horoscopeList:List<Horoscope> = listOf(
        Horoscope("aries","Aries",0),
        Horoscope("taurus","Taurus",0),
        Horoscope("gemini","Gemini",0),
        Horoscope("cancer","Cancer",0),
        Horoscope("leo","Leo",0),
        Horoscope("virgo","Virgo",0),
        Horoscope("aries","Aries",0),
        Horoscope("aries","Aries",0),
        Horoscope("aries","Aries",0),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
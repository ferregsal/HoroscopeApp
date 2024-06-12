package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"
    }
    lateinit var horoscope : Horoscope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent.getStringExtra(EXTRA_HOROSCOPE_ID)
        val name = intent.getIntExtra("HOROSCOPE_NAME", -1)
        val logo = intent.getIntExtra("HOROSCOPE_LOGO", -1)
        horoscope = HoroscopeProvider.findById(id!!)!!
        findViewById<TextView>(R.id.nameTextViewDetail).setText(horoscope.name)
        findViewById<ImageView>(R.id.imageViewDetail).setImageResource(horoscope.logo)
    }
}
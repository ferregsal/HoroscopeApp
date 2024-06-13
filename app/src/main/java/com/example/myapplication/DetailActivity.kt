package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"
    }
    lateinit var horoscope : Horoscope
    lateinit var backButton :Button
    lateinit var logoDetailCardView : CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent.getStringExtra(EXTRA_HOROSCOPE_ID)
        val name = intent.getIntExtra("HOROSCOPE_NAME", -1)
        val logo = intent.getIntExtra("HOROSCOPE_LOGO", -1)
        logoDetailCardView =findViewById(R.id.logoDetailCardView)
        horoscope = HoroscopeProvider.findById(id!!)!!
        findViewById<TextView>(R.id.nameTextViewDetail).setText(horoscope.name)
        findViewById<ImageView>(R.id.imageViewDetail).setImageResource(horoscope.logo)
        //findViewById<ImageView>(R.id.imageViewDetail).setBackgroundResource(horoscope.color)
        //findViewById<CardView>(R.id.logoDetailCardView).setCardBackgroundColor(logoDetailCardView.context.getColor(horoscope.color))
        if (horoscope.elemento=="FUEGO"){
            logoDetailCardView.setCardBackgroundColor(logoDetailCardView.context.getColor(R.color.granate))
        }
        else if (horoscope.elemento=="AGUA"){
            logoDetailCardView.setCardBackgroundColor(logoDetailCardView.context.getColor(R.color.azul_polvo))
        }
        else if (horoscope.elemento=="AIRE"){
            logoDetailCardView.setCardBackgroundColor(logoDetailCardView.context.getColor(R.color.gris_perla))
        }
        else if (horoscope.elemento=="TIERRA"){
            logoDetailCardView.setCardBackgroundColor(logoDetailCardView.context.getColor(R.color.ocre_dorado))
        }

        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}
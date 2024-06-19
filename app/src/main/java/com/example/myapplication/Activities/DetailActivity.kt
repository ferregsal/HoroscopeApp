package com.example.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.horoscopeapp.utils.SessionManager
import com.example.myapplication.Data.Horoscope
import com.example.myapplication.Data.HoroscopeProvider
import com.example.myapplication.R

class DetailActivity : AppCompatActivity() {


    companion object{
        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"
    }
    lateinit var horoscope : Horoscope
    lateinit var backButton :Button
    lateinit var logoDetailCardView : CardView
    lateinit var favoriteMenuItem: MenuItem
    var isFavorite = false
    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        session = SessionManager(this)
        val id = intent.getStringExtra(EXTRA_HOROSCOPE_ID)
        val name = intent.getIntExtra("HOROSCOPE_NAME", -1)
        val logo = intent.getIntExtra("HOROSCOPE_LOGO", -1)
        logoDetailCardView =findViewById(R.id.logoDetailCardView)
        horoscope = HoroscopeProvider.findById(id!!)!!
        isFavorite = session.isFavorite(horoscope.id)

        findViewById<TextView>(R.id.nameTextViewDetail).setText(horoscope.name)
        findViewById<ImageView>(R.id.imageViewDetail).setImageResource(horoscope.logo)
        //findViewById<ImageView>(R.id.imageViewDetail).setBackgroundResource(horoscope.color)
        //findViewById<CardView>(R.id.logoDetailCardView).setCardBackgroundColor(logoDetailCardView.context.getColor(horoscope.color))
        if (horoscope.element=="FUEGO"){
            logoDetailCardView.setCardBackgroundColor(logoDetailCardView.context.getColor(R.color.granate))
        }
        else if (horoscope.element=="AGUA"){
            logoDetailCardView.setCardBackgroundColor(logoDetailCardView.context.getColor(R.color.azul_polvo))
        }
        else if (horoscope.element=="AIRE"){
            logoDetailCardView.setCardBackgroundColor(logoDetailCardView.context.getColor(R.color.gris_perla))
        }
        else if (horoscope.element=="TIERRA"){
            logoDetailCardView.setCardBackgroundColor(logoDetailCardView.context.getColor(R.color.ocre_dorado))
        }

        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
    fun setFavoriteIcon () {
        if (isFavorite) {
            favoriteMenuItem.setIcon(R.drawable.ic_favorite_selected)
        } else {
            favoriteMenuItem.setIcon(R.drawable.ic_favorite)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_detail_menu, menu)
        favoriteMenuItem = menu.findItem(R.id.menu_favorite)
        setFavoriteIcon()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_favorite -> {
                toggleFavorite()
                true
            }
            R.id.menu_share -> {
                shareHoroscope()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun toggleFavorite() {
        if (isFavorite) {
            session.setFavoriteHoroscope(horoscope.id, false)
        } else {
            session.setFavoriteHoroscope(horoscope.id, true)
        }
        isFavorite = !isFavorite
        setFavoriteIcon()
    }
    private fun shareHoroscope() {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

}

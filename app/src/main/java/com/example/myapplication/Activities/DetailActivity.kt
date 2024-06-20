package com.example.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopeapp.utils.SessionManager
import com.example.myapplication.Adapters.CompatibilityAdapter
import com.example.myapplication.Adapters.HoroscopeAdapter
import com.example.myapplication.Data.Horoscope
import com.example.myapplication.Data.HoroscopeProvider
import com.example.myapplication.Data.HoroscopeProvider.Companion.horoscopeList
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class DetailActivity : AppCompatActivity() {


    companion object{
        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"

    }
    private var dailyLuckText:String? = null
    lateinit var horoscope : Horoscope
    lateinit var backButton :Button
    lateinit var logoDetailCardView : CardView
    lateinit var favoriteMenuItem: MenuItem
    lateinit var compatRecyclerView: RecyclerView
    lateinit var compatProgressBar: ProgressBar
    var isFavorite = false
    lateinit var session: SessionManager
    lateinit var dailyHoroscopeTextView: TextView
    private lateinit var adapter: CompatibilityAdapter
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
        dailyHoroscopeTextView = findViewById(R.id.dailyHoroscopeTextView)
        compatRecyclerView = findViewById(R.id.compatRecyclerView)
        adapter = CompatibilityAdapter(horoscopeList)
        findViewById<TextView>(R.id.nameTextViewDetail).setText("${getString(horoscope.name)} daily horoscope")
        findViewById<ImageView>(R.id.imageViewDetail).setImageResource(horoscope.logo)
        getDailyHoroscope()
        compatRecyclerView.adapter = adapter
        compatRecyclerView.layoutManager = LinearLayoutManager(this)

        //findViewById<ImageView>(R.id.imageViewDetail).setBackgroundResource(horoscope.color)
        //findViewById<CardView>(R.id.logoDetailCardView).setCardBackgroundColor(logoDetailCardView.context.getColor(horoscope.color))
      /*  if (horoscope.element=="FUEGO"){
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
        }*/


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

    private fun getDailyHoroscope() {
        // Llamada en hilo secundario
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Declaramos la url
                val url = URL("https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=${horoscope.id}&day=TODAY")
                val con = url.openConnection() as HttpsURLConnection
                con.requestMethod = "GET"
                val responseCode = con.responseCode
                Log.i("HTTP", "Response Code :: $responseCode")

                // Preguntamos si hubo error o no
                if (responseCode == HttpsURLConnection.HTTP_OK) { // Ha ido bien
                    // Metemos el cuerpo de la respuesta en un BurfferedReader
                    val bufferedReader = BufferedReader(InputStreamReader(con.inputStream))
                    var inputLine: String?
                    val response = StringBuffer()
                    while (bufferedReader.readLine().also { inputLine = it } != null) {
                        response.append(inputLine)
                    }
                    bufferedReader.close()

                    // Parsear JSON
                    val json = JSONObject(response.toString())
                    val result =  json.getJSONObject("data").getString("horoscope_data")

                    // Ejecutamos en el hilo principal
                    /*CoroutineScope(Dispatchers.Main).launch {

                    }*/
                    runOnUiThread {
                        dailyHoroscopeTextView.text = result
                    }

                } else { // Hubo un error
                    Log.w("HTTP", "Response :: Hubo un error")
                }
            } catch (e: Exception) {
                Log.e("HTTP", "Response Error :: ${e.stackTraceToString()}")
            }
        }
    }
}



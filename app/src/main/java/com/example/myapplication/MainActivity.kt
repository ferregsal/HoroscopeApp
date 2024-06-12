package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var horoscopeList: List<Horoscope>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        horoscopeList = HoroscopeProvider.findAll()
        recyclerView=findViewById(R.id.recyclerView)


            val adapter = HoroscopeAdapter(horoscopeList){position ->
                navigateToDetail(horoscopeList[position])
            }
            recyclerView.adapter = adapter
            recyclerView.layoutManager= GridLayoutManager(this, 2)
            //recyclerView.setBackgroundColor(Horoscope.color)


        }
    fun navigateToDetail(horoscope:Horoscope){
        val intent:Intent=Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID, horoscope.id)
        intent.putExtra("HOROSCOPE_NAME", horoscope.name)
        intent.putExtra("HOROSCOPE_LOGO", horoscope.logo)
        startActivity(intent)
    }
}
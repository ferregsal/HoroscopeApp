package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var horoscopeList: List<Horoscope>
    lateinit var filterFuegoSwitch: Switch
    lateinit var filterAireSwitch: Switch
    lateinit var filterAguaSwitch: Switch
    lateinit var filterTierraSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        horoscopeList = HoroscopeProvider.findAll()
        recyclerView=findViewById(R.id.recyclerView)
        filterFuegoSwitch = findViewById(R.id.filterFuegoSwitch)
        filterAireSwitch = findViewById(R.id.filterAireSwitch)
        filterAguaSwitch = findViewById(R.id.filterAguaSwitch)
        filterTierraSwitch = findViewById(R.id.filterTierraSwitch)
/*
        filterFuegoSwitch?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked) "filterFuegoSwitch:ON" else "filterFuegoSwitch:OFF"
            Toast.makeText(this@MainActivity, message,
                Toast.LENGTH_SHORT).show()
        })
        filterAireSwitch = findViewById(R.id.filterAireSwitch)
        filterAireSwitch?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked) "filterAireSwitch:ON" else "filterAireSwitch:OFF"
            Toast.makeText(this@MainActivity, message,
                Toast.LENGTH_SHORT).show()
        })
        filterAguaSwitch = findViewById(R.id.filterAguaSwitch)
        filterAguaSwitch?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked) "filterAguaSwitch:ON" else "filterAguaSwitch:OFF"
            Toast.makeText(this@MainActivity, message,
                Toast.LENGTH_SHORT).show()
        })
        filterTierraSwitch = findViewById(R.id.filterTierraSwitch)
        filterTierraSwitch?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked) "filterTierraSwitch:ON" else "filterTierraSwitch:OFF"
            Toast.makeText(this@MainActivity, message,
                Toast.LENGTH_SHORT).show()
        }) */

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
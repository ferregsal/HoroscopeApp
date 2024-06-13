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
    private lateinit var adapter: HoroscopeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        horoscopeList = HoroscopeProvider.findAll()
        recyclerView=findViewById(R.id.recyclerView)
        filterFuegoSwitch = findViewById(R.id.filterFuegoSwitch)
        filterAireSwitch = findViewById(R.id.filterAireSwitch)
        filterAguaSwitch = findViewById(R.id.filterAguaSwitch)
        filterTierraSwitch = findViewById(R.id.filterTierraSwitch)


            adapter = HoroscopeAdapter(horoscopeList){position ->
                navigateToDetail(horoscopeList[position])
            }
            recyclerView.adapter = adapter
            recyclerView.layoutManager= GridLayoutManager(this, 2)
            //recyclerView.setBackgroundColor(Horoscope.color)
            setupSwitchListeners()

        }

    private fun setupSwitchListeners() {
        val switchListener = {
            applyFilters()
        }

        filterFuegoSwitch.setOnCheckedChangeListener { _, _ -> switchListener() }
        filterAireSwitch.setOnCheckedChangeListener { _, _ -> switchListener() }
        filterAguaSwitch.setOnCheckedChangeListener { _, _ -> switchListener() }
        filterTierraSwitch.setOnCheckedChangeListener { _, _ -> switchListener() }
    }

    private fun applyFilters() {
        horoscopeList = HoroscopeProvider.findAll().filter {
            (filterFuegoSwitch.isChecked && it.elemento == "FUEGO") ||
                    (filterAireSwitch.isChecked && it.elemento == "AIRE") ||
                    (filterAguaSwitch.isChecked && it.elemento == "AGUA") ||
                    (filterTierraSwitch.isChecked && it.elemento == "TIERRA") ||
                    (!filterFuegoSwitch.isChecked && !filterAireSwitch.isChecked && !filterAguaSwitch.isChecked && !filterTierraSwitch.isChecked)
        }
     adapter.updateData(horoscopeList)
    }

    fun navigateToDetail(horoscope:Horoscope){
        val intent:Intent=Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID, horoscope.id)
        intent.putExtra("HOROSCOPE_NAME", horoscope.name)
        intent.putExtra("HOROSCOPE_LOGO", horoscope.logo)
        startActivity(intent)
    }
}
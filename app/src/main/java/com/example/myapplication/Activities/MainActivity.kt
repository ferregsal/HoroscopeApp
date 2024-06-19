package com.example.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import com.example.horoscopeapp.utils.SessionManager
import com.example.myapplication.Data.Horoscope
import com.example.myapplication.Adapters.HoroscopeAdapter
import com.example.myapplication.Data.HoroscopeProvider
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {
    lateinit var horoscope : Horoscope
    private var horoscopeList: List<Horoscope> = HoroscopeProvider.horoscopeList
    lateinit var recyclerView: RecyclerView
    lateinit var filterFuegoSwitch: Switch
    lateinit var filterAireSwitch: Switch
    lateinit var filterAguaSwitch: Switch
    lateinit var filterTierraSwitch: Switch
    var showFavorites = false
    lateinit var favoritesMenu: MenuItem
    var searchText: String? = null
    private lateinit var adapter: HoroscopeAdapter
    lateinit var session: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        session = SessionManager(this)

        horoscopeList = HoroscopeProvider.findAll()
        recyclerView = findViewById(R.id.recyclerView)
        filterFuegoSwitch = findViewById(R.id.filterFuegoSwitch)
        filterAireSwitch = findViewById(R.id.filterAireSwitch)
        filterAguaSwitch = findViewById(R.id.filterAguaSwitch)
        filterTierraSwitch = findViewById(R.id.filterTierraSwitch)

        adapter = HoroscopeAdapter(horoscopeList) { position ->
            navigateToDetail(horoscopeList[position])
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        //recyclerView.setBackgroundColor(Horoscope.color)
        setupSwitchListeners()

    }
    override fun onResume() {
        super.onResume()
        adapter.updateData(horoscopeList)
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
            (filterFuegoSwitch.isChecked && it.element == "FUEGO") ||
                    (filterAireSwitch.isChecked && it.element == "AIRE") ||
                    (filterAguaSwitch.isChecked && it.element == "AGUA") ||
                    (filterTierraSwitch.isChecked && it.element == "TIERRA") ||
                    (!filterFuegoSwitch.isChecked && !filterAireSwitch.isChecked && !filterAguaSwitch.isChecked && !filterTierraSwitch.isChecked)
        }
        if (showFavorites) {
            val favoriteIds = session.getAllFavoriteHoroscopes()
            horoscopeList = horoscopeList.filter { favoriteIds.contains(it.id) }
        }
        if (searchText != null) {
            horoscopeList = horoscopeList.filter {
                getString(it.name).contains(searchText!!, true) ||
                        getString(it.description).contains(searchText!!, true)
            }
        }
        adapter.updateData(horoscopeList)
    }

    fun navigateToDetail(horoscope: Horoscope) {
        val intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID, horoscope.id)
        intent.putExtra("HOROSCOPE_NAME", horoscope.name)
        intent.putExtra("HOROSCOPE_LOGO", horoscope.logo)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)

        favoritesMenu = menu.findItem(R.id.menu_favorites)

        val searchViewItem = menu.findItem(R.id.menu_search)
        val searchView = searchViewItem.actionView as SearchView


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {


            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchText = newText
                applyFilters()
                return true
            }

        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_favorites -> {
                showFavorites = !showFavorites
                if (showFavorites) {
                    favoritesMenu.setIcon(R.drawable.ic_favorite_selected)
                } else {
                    favoritesMenu.setIcon(R.drawable.ic_favorite)
                }
                applyFilters()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun initSearchView(searchItem: MenuItem?) {
        var horoscopeList: List<Horoscope>
        if (searchItem != null) {
            var searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    if (query.isNullOrEmpty()) {
                        horoscopeList = HoroscopeProvider.findAll()
                    } else {
                        horoscopeList = HoroscopeProvider.findAll()
                            .filter { getString(it.name).contains(query, true) }
                    }
                    adapter.updateData(horoscopeList)
                    return true
                }
            })
        }
    }
}

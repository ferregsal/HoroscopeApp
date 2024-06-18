package com.example.horoscopeapp.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    companion object {
        const val FAVORITE_HOROSCOPE = "FAVORITE_HOROSCOPE"
    }

    private val sharedPref: SharedPreferences

    init {
        sharedPref = context.getSharedPreferences("horoscope_session", Context.MODE_PRIVATE)
    }
    fun isFavorite(horoscopeId: String): Boolean {
        return sharedPref.getBoolean("FAVORITE_HOROSCOPE_$horoscopeId", false)
    }

    fun setFavoriteHoroscope(horoscopeId: String, isFavorite: Boolean) {
        val editor = sharedPref.edit()
        editor.putBoolean("FAVORITE_HOROSCOPE_$horoscopeId", isFavorite)
        editor.apply()
    }

    fun getAllFavoriteHoroscopes(): List<String> {
        val allFavorites = mutableListOf<String>()
        for (entry in sharedPref.all) {
            if (entry.key.startsWith("FAVORITE_HOROSCOPE_") && entry.value as Boolean) {
                allFavorites.add(entry.key.removePrefix("FAVORITE_HOROSCOPE_"))
            }
        }
        return allFavorites
    }


}
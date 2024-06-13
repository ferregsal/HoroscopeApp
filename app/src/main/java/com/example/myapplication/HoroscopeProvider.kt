package com.example.myapplication

class HoroscopeProvider {
    companion object {
        private val horoscopeList:List<Horoscope> = listOf(
            Horoscope("aries", R.string.horoscope_name_aries,R.string.horoscope_date_aries, R.drawable.aries_icon , R.color.gris_perla,"FUEGO"),
            Horoscope("taurus", R.string.horoscope_name_taurus,R.string.horoscope_date_taurus, R.drawable.taurus_icon, R.color.gris_carbón,"TIERRA"),
            Horoscope("gemini", R.string.horoscope_name_gemini,R.string.horoscope_date_gemini, R.drawable.gemini_icon, R.color.beige_claro,"AIRE"),
            Horoscope("cancer", R.string.horoscope_name_cancer,R.string.horoscope_date_cancer, R.drawable.cancer_icon, R.color.coral_suave,"AGUA"),
            Horoscope("leo", R.string.horoscope_name_leo,R.string.horoscope_date_leo, R.drawable.leo_icon, R.color.ocre_dorado,"FUEGO"),
            Horoscope("virgo", R.string.horoscope_name_virgo,R.string.horoscope_date_virgo, R.drawable.virgo_icon, R.color.verde_salvia,"TIERRA"),
            Horoscope("libra", R.string.horoscope_name_libra,R.string.horoscope_date_libra, R.drawable.libra_icon, R.color.azul_polvo,"AIRE"),
            Horoscope("scorpio", R.string.horoscope_name_scorpio,R.string.horoscope_date_scorpio, R.drawable.scorpio_icon, R.color.granate,"AGUA"),
            Horoscope("sagittarius", R.string.horoscope_name_sagittarius,R.string.horoscope_date_sagittarius, R.drawable.sagittarius_icon, R.color.lila,"FUEGO"),
            Horoscope("capricorn", R.string.horoscope_name_capricorn,R.string.horoscope_date_capricorn, R.drawable.capricorn_icon, R.color.verde_oliva,"TIERRA"),
            Horoscope("aquarius", R.string.horoscope_name_aquarius,R.string.horoscope_date_aquarius, R.drawable.aquarius_icon, R.color.azul_acero,"AIRE"),
            Horoscope("pisces", R.string.horoscope_name_pisces,R.string.horoscope_date_pisces, R.drawable.pisces_icon, R.color.azul_pálido,"AGUA")
        )
        fun findAll():List<Horoscope>{
            return horoscopeList
        }
        fun findById(id:String) : Horoscope/* ? declara que es opcional*/{
            return horoscopeList.find {it.id == id}!! //no es opcional, seguro que tiene un valor
        }
    }

}
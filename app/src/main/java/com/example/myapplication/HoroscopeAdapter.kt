package com.example.myapplication


import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.absoluteValue

class HoroscopeAdapter(private val dataSet: List<Horoscope>,
    val onItemClickListener: (Int) -> Unit):
    RecyclerView.Adapter<HoroscopeAdapter.HoroscopeViewHolder>() {



    open class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val logoImageView: ImageView
        val descriptionTextView: TextView
        val logoCardView : CardView
        var filterFuegoSwitch: Switch
        var filterAireSwitch: Switch
        var filterAguaSwitch: Switch
        var filterTierraSwitch: Switch

        init {
            // Define click listener for the ViewHolder's View
            nameTextView = view.findViewById(R.id.nameTextView)
            logoImageView = view.findViewById(R.id.logoImageView)
            descriptionTextView = view.findViewById(R.id.descriptionTextview)
            logoCardView = view.findViewById(R.id.logoCardView)
            filterFuegoSwitch = view.findViewById(R.id.filterFuegoSwitch)
            filterAireSwitch = view.findViewById(R.id.filterAireSwitch)
            filterAguaSwitch = view.findViewById(R.id.filterAguaSwitch)
            filterTierraSwitch = view.findViewById(R.id.filterTierraSwitch)

        }
        fun render(horoscope: Horoscope) {
            nameTextView.setText(horoscope.name)
            descriptionTextView.setText(horoscope.description)
            logoImageView.setImageResource(horoscope.logo)
            //logoImageView.setBackgroundResource(horoscope.color)
            //logoCardView.setBackgroundResource(horoscope.color)
            //logoCardView.setCardBackgroundColor(logoCardView.context.getColor(horoscope.color))
            when (horoscope.elemento) {
                "FUEGO" -> logoCardView.setCardBackgroundColor(logoCardView.context.getColor(R.color.granate))
                "AGUA" -> logoCardView.setCardBackgroundColor(logoCardView.context.getColor(R.color.azul_polvo))
                "AIRE" -> logoCardView.setCardBackgroundColor(logoCardView.context.getColor(R.color.gris_perla))
                "TIERRA" -> logoCardView.setCardBackgroundColor(logoCardView.context.getColor(R.color.ocre_dorado))
            }

    }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HoroscopeViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_horoscope, viewGroup, false)

        return HoroscopeViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: HoroscopeViewHolder, position: Int) {

        val horoscope = dataSet[position]

        viewHolder.render(horoscope)
        viewHolder.itemView.setOnClickListener{onItemClickListener(position)}
       // viewHolder.nameTextView.text = horoscope.name
       // viewHolder.logoImageView.setImageResource(horoscope.logo)
       // viewHolder.descriptionTextView.text = horoscope.description
       // viewHolder.logoImageView.setBackgroundColor(horoscope.color)



    }

    override fun getItemCount():Int {
        return dataSet.size
    }
}

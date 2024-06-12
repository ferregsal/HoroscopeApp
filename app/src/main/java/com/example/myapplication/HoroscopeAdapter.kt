package com.example.myapplication


import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HoroscopeAdapter(private val dataSet: List<Horoscope>) :
    RecyclerView.Adapter<HoroscopeAdapter.HoroscopeViewHolder>() {


    class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val logoImageView: ImageView
        val descriptionTextView: TextView
        val cardViewGrid :View
        init {
            // Define click listener for the ViewHolder's View
            nameTextView = view.findViewById(R.id.nameTextView)
            logoImageView = view.findViewById(R.id.logoImageView)
            descriptionTextView = view.findViewById(R.id.descriptionTextview)
            cardViewGrid = view.findViewById(R.id.cardViewGrid)
        }
        fun render(horoscope: Horoscope) {
            nameTextView.setText(horoscope.name)
            descriptionTextView.setText(horoscope.description)
            logoImageView.setImageResource(horoscope.logo)
            logoImageView.setBackgroundResource(horoscope.color)
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
       // viewHolder.nameTextView.text = horoscope.name
       // viewHolder.logoImageView.setImageResource(horoscope.logo)
       // viewHolder.descriptionTextView.text = horoscope.description
       // viewHolder.logoImageView.setBackgroundColor(horoscope.color)


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount():Int {
        return dataSet.size
    }
}

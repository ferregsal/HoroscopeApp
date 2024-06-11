package com.example.myapplication


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
        val imageView: ImageView
        val descriptionTextView: TextView


        init {
            // Define click listener for the ViewHolder's View
            nameTextView = view.findViewById(R.id.nameTextView)
            imageView = view.findViewById(R.id.logoImageView)
            descriptionTextView = view.findViewById(R.id.descriptionTextview)
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
        viewHolder.nameTextView.text = horoscope.name
        viewHolder.imageView.setImageResource(horoscope.logo)
        viewHolder.descriptionTextView.text = horoscope.description
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount():Int {
        return dataSet.size
    }
}

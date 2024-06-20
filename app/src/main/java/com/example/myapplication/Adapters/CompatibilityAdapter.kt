package com.example.myapplication.Adapters


import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopeapp.utils.SessionManager
import com.example.myapplication.Data.Horoscope
import com.example.myapplication.R


class CompatibilityAdapter(private var dataSet: List<Horoscope>):
    RecyclerView.Adapter<CompatibilityAdapter.HoroscopeViewHolder>() {



    open class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var nameCompatTextView: TextView
        var compatProgressBar: ProgressBar

        init {


           nameCompatTextView = view.findViewById(R.id.nameCompatTextView)
            compatProgressBar = view.findViewById(R.id.compatProgressBar)


        }
        fun render(horoscope: Horoscope) {



            //logoImageView.setBackgroundResource(horoscope.color)
            //logoCardView.setBackgroundResource(horoscope.color)
            //logoCardView.setCardBackgroundColor(logoCardView.context.getColor(horoscope.color))
           /* when (horoscope.element) {
                "FUEGO" -> logoCardView.setCardBackgroundColor(logoCardView.context.getColor(R.color.granate))
                "AGUA" -> logoCardView.setCardBackgroundColor(logoCardView.context.getColor(R.color.azul_polvo))
                "AIRE" -> logoCardView.setCardBackgroundColor(logoCardView.context.getColor(R.color.gris_perla))
                "TIERRA" -> logoCardView.setCardBackgroundColor(logoCardView.context.getColor(R.color.ocre_dorado))
            } */

    }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HoroscopeViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_compatibility, viewGroup, false)

        return HoroscopeViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: HoroscopeViewHolder, position: Int) {
        val horoscope = dataSet[position]

        viewHolder.nameCompatTextView.setText(horoscope.name)
        viewHolder.compatProgressBar.setProgress((8.33f * (12 - position)).toInt())
        when(viewHolder.compatProgressBar.progress){
            in 1..8.33.toInt()-> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED))
            in 9..16.66.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED))
            in 17..24.99.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED))
            in 25..33.22.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 34..41.55.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 42..49.88.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 50..58.11.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 59..66.44.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 67..74.77.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN))
            in 75..83.3.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN))
            in 84..91.63.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN))
            in 92..99.96.toInt() -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN))


        }



    }

    override fun getItemCount():Int {
        return dataSet.size
    }
    fun updateData(newDataSet: List<Horoscope>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }

}

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
        viewHolder.compatProgressBar.setProgress((9*(11-position)))
        when(viewHolder.compatProgressBar.progress){
            in 1..9 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED))
            in 10..18 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED))
            in 19..27 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED))
            in 28..36 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 37..45 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 46..54 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 55..63 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 64..72 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW))
            in 73..81 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN))
            in 82..90 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN))
            in 91..99 -> viewHolder.compatProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN))


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

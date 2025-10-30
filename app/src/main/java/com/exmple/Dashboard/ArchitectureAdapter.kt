package com.exmple.Dashboard

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.exmple.R
class ArchitectureAdapter(
    private val items: List<String>,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<ArchitectureAdapter.ArchViewHolder>() {

    class ArchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameValue: TextView = itemView.findViewById(R.id.txtTitle)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_architecture, parent, false)
        return ArchViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArchViewHolder, position: Int) {
        val item = items[position]
        holder.tvNameValue.text = item
        holder.tvNameValue.setOnClickListener { listener.onItemClick(item) }
        val colors = holder.itemView.resources.getStringArray(R.array.light_colors)
        var colorIndex = (0 until colors.size).random()

        // Check previous item color if available and adjust if same
        if (position > 0) {
            val previousColor = getItemColor(position - 1)
            while (Color.parseColor(colors[colorIndex]) == previousColor) {
                colorIndex = (0 until colors.size).random()
            }
        }
        // Save color for this position
        val cardColor = Color.parseColor(colors[colorIndex])
        setItemColor(position, cardColor) // store color in map
        holder.cardView.setCardBackgroundColor(cardColor)
    }
    private val itemColorMap = mutableMapOf<Int, Int>()

    private fun getItemColor(position: Int): Int? = itemColorMap[position]
    private fun setItemColor(position: Int, color: Int) {
        itemColorMap[position] = color
    }

    override fun getItemCount() = items.size
}
package com.example.project2_wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.math.RoundingMode
import java.text.DecimalFormat

class CuriosAdapter(private val curiosList: MutableList<Curio>) : RecyclerView.Adapter<CuriosAdapter.ViewHolder>()
{
	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
	{
		val itemNameTextViewRV: TextView
		val itemURLTextViewRV: TextView
		val itemPriceTextViewRV: TextView

		init
		{
			itemNameTextViewRV = itemView.findViewById(R.id.itemNameRv)
			itemURLTextViewRV = itemView.findViewById(R.id.itemURLRv)
			itemPriceTextViewRV = itemView.findViewById(R.id.itemPriceRv)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
	{
		val context = parent.context
		val inflater = LayoutInflater.from(context)
		val contactView = inflater.inflate(R.layout.curios_item, parent, false)

		return ViewHolder(contactView)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int)
	{
		val curio = curiosList[position]

		holder.itemNameTextViewRV.text = curio.name
		holder.itemURLTextViewRV.text = curio.url
		holder.itemPriceTextViewRV.text = String.format("%.2f", curio.price)
	}

	override fun getItemCount(): Int
	{
		return curiosList.size
	}
}
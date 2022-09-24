package com.example.project2_wishlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CuriosAdapter(private val curiosList: MutableList<Curio>) : RecyclerView.Adapter<CuriosAdapter.ViewHolder>()
{
	// Define the listener interface
	interface OnItemClickListener
	{
		fun onItemClick(itemView: View?, position: Int)
	}

	// Define listener member variable
	private lateinit var listener: OnItemClickListener

	// Define the method that allows the parent activity or fragment to define the listener
	fun setOnItemLongClickListener(listener: OnItemClickListener)
	{
		this.listener = listener
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
	{
		val itemNameTextViewRV: TextView
		val itemURLTextViewRV: TextView
		val itemPriceTextViewRV: TextView

		init
		{
			itemNameTextViewRV = itemView.findViewById(R.id.itemNameRv)
			itemURLTextViewRV = itemView.findViewById(R.id.itemURLRv)
			itemPriceTextViewRV = itemView.findViewById(R.id.itemPriceRv)

			itemURLTextViewRV.setOnClickListener {
				try
				{
					val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(itemURLTextViewRV.text.toString()))
					ContextCompat.startActivity(it.context, browserIntent, null)
				}
				catch (e: ActivityNotFoundException) {
					Toast.makeText(it.context, "Invalid URL for " + itemNameTextViewRV.text.toString(), Toast.LENGTH_LONG).show()
				}
			}

			itemView.setOnLongClickListener {
				val position = adapterPosition

				if (position != RecyclerView.NO_POSITION)
				{
					listener.onItemClick(itemView, position)
				}

				true
			}

//			itemView.setOnLongClickListener(this)
		}


		// Other way of removing item. Need to add View.OnClickListener to implement
//		override fun onLongClick(v: View?): Boolean
//		{
//			val position = adapterPosition
//
//			if (position != RecyclerView.NO_POSITION)
//			{
//				curiosList.removeAt(position)
//				notifyItemRemoved(position)
//				return true
//			}
//			return false
//		}

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

package com.example.project2_wishlist

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.SpannableString
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#146775")))

		val curiosList: MutableList<Curio> = mutableListOf()

		val recyclerView = findViewById<RecyclerView>(R.id.curiosRV)
		val curiosAdapter = CuriosAdapter(curiosList)

		recyclerView.adapter = curiosAdapter
		recyclerView.layoutManager = LinearLayoutManager(this)

		val itemName = findViewById<EditText>(R.id.itemName)
		val itemURL = findViewById<EditText>(R.id.itemURL)
		val itemPrice = findViewById<EditText>(R.id.itemPrice)
		val submitBtn = findViewById<Button>(R.id.submitBtn)

		submitBtn.setOnClickListener {

			if (itemName.text.isNotEmpty() && itemURL.text.isNotEmpty() && itemPrice.text.isNotEmpty())
			{
				val curio = Curio(itemName.text.toString(), itemURL.text.toString(), itemPrice.text.toString().toDouble())

				val curSize = curiosAdapter.itemCount
				curiosList.add(curio)

				itemName.text.clear()
				itemURL.text.clear()
				itemPrice.text.clear()

				curiosAdapter.notifyItemRangeInserted(curSize, curiosList.size)
			}
			else
			{
				Toast.makeText(applicationContext, "All forms must be filled.", Toast.LENGTH_SHORT).show()
			}
		}

		curiosAdapter.setOnItemLongClickListener(object : CuriosAdapter.OnItemClickListener
		{
			override fun onItemClick(itemView: View?, position: Int)
			{
				curiosList.removeAt(position)
				curiosAdapter.notifyItemRemoved(position)
			}
		})

	}
}
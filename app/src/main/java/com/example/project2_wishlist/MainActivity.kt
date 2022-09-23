package com.example.project2_wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

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
			val curio = Curio(itemName.text.toString(), itemURL.text.toString(), itemPrice.text.toString().toDouble())

			curiosList.add(curio)

			itemName.text.clear()
			itemURL.text.clear()
			itemPrice.text.clear()

			curiosAdapter.notifyItemChanged(curiosAdapter.itemCount)
		}

	}
}
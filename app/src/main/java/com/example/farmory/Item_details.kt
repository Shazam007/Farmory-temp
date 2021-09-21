package com.example.farmory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.farmory.Itemlist.Modeitem
import com.example.farmory.databinding.ActivityItemDetailsBinding

class Item_details : AppCompatActivity() {


    private lateinit var  binding: ActivityItemDetailsBinding

    private  lateinit var itemList: ArrayList<Modeitem>
    private var positionClicked:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        itemList = intent.getSerializableExtra("items") as ArrayList<Modeitem>
        positionClicked = intent.getIntExtra("position",0)


        binding.itemTitle.text = itemList[positionClicked].title
        binding.ItemImage.setImageResource(itemList[positionClicked].image)
        binding.itemDescription.text = itemList[positionClicked].description




    }
}
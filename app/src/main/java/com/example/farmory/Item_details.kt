package com.example.farmory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.navigation.fragment.findNavController
import com.example.farmory.Itemlist.Modeitem
import com.example.farmory.databinding.ActivityItemDetailsBinding
import android.content.Intent
import com.example.farmory.homeMenuTabs.MenuSearchFragment


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


        this.findViewById<ImageButton>(R.id.back_button).setOnClickListener{
            val intent = Intent(this, MenuSearchFragment::class.java)
            startActivity(intent)
//            Toast.makeText(this, "cliced", Toast.LENGTH_SHORT).show()
        }
        supportActionBar?.hide()

    }
}
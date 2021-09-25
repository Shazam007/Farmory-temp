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
import com.google.android.material.internal.ContextUtils.getActivity


class Item_details : AppCompatActivity() {


    private lateinit var  binding: ActivityItemDetailsBinding

    private  lateinit var itemList: ArrayList<Modeitem>
    private var positionClicked:Int = 0

    private  var qunty:Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        itemList = intent.getSerializableExtra("items") as ArrayList<Modeitem>
        positionClicked = intent.getIntExtra("position",0)


        binding.itemTitle.text = itemList[positionClicked].title
        binding.ItemImage.setImageResource(itemList[positionClicked].image)
        binding.itemDescription.text = itemList[positionClicked].description
        binding.itemQuntity.text = qunty.toString()
        binding.itemPrice.text = (itemList[positionClicked].description.toInt() * qunty ).toFloat().toString()


        this.findViewById<ImageButton>(R.id.back_button).setOnClickListener{
            val intent = Intent(this, MenuSearchFragment::class.java)
            startActivity(intent)
        }

        this.findViewById<ImageButton>(R.id.content_increce_btn).setOnClickListener{
           qunty+=1
            binding.itemQuntity.text = qunty.toString()
            binding.itemPrice.text = (itemList[positionClicked].description.toInt() * qunty ).toFloat().toString()
        }

        this.findViewById<ImageButton>(R.id.content_reduce_btn).setOnClickListener{
            if(qunty == 0){
                qunty = 0
            }else{
                qunty-=1
            }

            binding.itemQuntity.text = qunty.toString()
            binding.itemPrice.text = (itemList[positionClicked].description.toInt() * qunty ).toFloat().toString()
        }


        supportActionBar?.hide()

    }


}
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
import android.widget.Button
import com.example.farmory.homeMenuTabs.MenuSearchFragment
import com.google.android.material.internal.ContextUtils.getActivity


class Item_details : AppCompatActivity() {

    private val Productdescriptions = arrayOf(
        "A banana is an elongated, edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. In some countries, bananas used for cooking may be called \"plantains\", distinguishing them from dessert bananas",
        "An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",
        "Cabbage, comprising several cultivars of Brassica oleracea, is a leafy green, red, or white biennial plant grown as an annual vegetable crop for its dense-leaved heads",
        "Eggplant, aubergine or brinjal is a plant species in the nightshade family Solanaceae. Solanum melongena is grown worldwide for its edible fruit. Most commonly purple, the spongy, absorbent fruit is used in several cuisines. Typically used as a vegetable in cooking, it is a berry by botanical definition",
        "The carrot is a root vegetable, typically orange in color, though purple, black, red, white, and yellow cultivars exist, all of which are domesticated forms of the wild carrot, Daucus carota, native to Europe and Southwestern Asia.",
        "A mango is an edible stone fruit produced by the tropical tree Mangifera indica which is believed to have originated from the region between northwestern Myanmar, Bangladesh, and northeastern India",
    )


    private lateinit var  binding: ActivityItemDetailsBinding

    private  lateinit var itemList: ArrayList<Modeitem>
    private var positionClicked:Int = 0

    private  var qunty:Int = 1;
    private var product_title:String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        itemList = intent.getSerializableExtra("items") as ArrayList<Modeitem>
        positionClicked = intent.getIntExtra("position",0)


        binding.itemTitle.text = itemList[positionClicked].title
        product_title = itemList[positionClicked].title
        binding.ItemImage.setImageResource(itemList[positionClicked].image)
        binding.itemDescription.text = itemList[positionClicked].description
        binding.descriptionTitle.text = itemList[positionClicked].title
        binding.itemDescriptionDesc.text = Productdescriptions[positionClicked]
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

        this.findViewById<Button>(R.id.add_to_cart).setOnClickListener{
            Toast.makeText(applicationContext,"$qunty kg $product_title added to the cart",Toast.LENGTH_SHORT).show()
        }


        supportActionBar?.hide()

    }





}
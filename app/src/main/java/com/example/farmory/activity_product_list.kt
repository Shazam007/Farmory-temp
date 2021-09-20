package com.example.farmory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.farmory.Itemlist.AdapterItem
import com.example.farmory.Itemlist.Modeitem
import com.example.farmory.databinding.ActivityProductListBinding
import com.example.farmory.databinding.FragmentMenuSearchBinding

class activity_product_list : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding

    private val titles = arrayOf(
        "Apple",
        "Apple",
        "Apple",
    )
    private val descriptions = arrayOf(
        "Rs 80 / g",
        "Rs 90 / g",
        "Rs 100 / g",
    )
    private val images = arrayOf(
        R.drawable.item1,
        R.drawable.item1,
        R.drawable.item1,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadRecycleViewItems()
//        setContentView(R.layout.activity_product_list)
    }

    private fun loadRecycleViewItems(){
//        val linerLayoutManager = LinearLayoutManager(this)
        val gridLayoutManager = GridLayoutManager(this,2)
//        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,1)

//        binding.productList.layoutManager = linerLayoutManager
        binding.productList.layoutManager = gridLayoutManager

        val itemList:ArrayList<Modeitem> = ArrayList()

        for (i in titles.indices){
            val model = Modeitem(titles[i],descriptions[i],images[i])

            itemList.add(model)
        }

        val adapterItem = AdapterItem(this, itemList)
        binding.productList.adapter = adapterItem

    }
}
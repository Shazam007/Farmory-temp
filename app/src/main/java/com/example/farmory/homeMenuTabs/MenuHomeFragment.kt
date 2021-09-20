package com.example.farmory.homeMenuTabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.farmory.R
import com.example.farmory.homeScreen.Category
import com.example.farmory.homeScreen.CategoryAdapter


class MenuHomeFragment : Fragment() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Category>
    lateinit var imageID : Array<Int>
    lateinit var categoryText : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu_home, container, false)

        view.findViewById<TextView>(R.id.seeMoreCategoriesButton).setOnClickListener{
            findNavController().navigate(R.id.action_menuHomeFragment_to_categoriesFragment)
        }

        imageID = arrayOf(R.drawable.ic_cat_vegetables,R.drawable.ic_cat_fruit,R.drawable.ic_cat_bread,R.drawable.ic_cat_meat,
            R.drawable.ic_cat_cereals,R.drawable.ic_cat_fish,R.drawable.ic_cat_dairy,R.drawable.ic_cat_ice_cream,
            R.drawable.ic_cat_drinks,R.drawable.ic_cat_liquor,R.drawable.ic_cat_chocolate,R.drawable.ic_cat_pepper)

        categoryText = resources.getStringArray(R.array.category);

        //categoryText = arrayOf("Fruit","Vegetable","Bakery","cereal","Meat","Seafood","Diary","Eggs","Drinks","Liquor","Candy","Spices")

        newRecyclerView = view.findViewById<RecyclerView>(R.id.category_recycler_view)

        newRecyclerView.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Category>()
        getUserdata()

        return view
    }

    private fun getUserdata() {

        for (i in imageID.indices){
            if(i<4) {
                val category = Category(imageID[i], categoryText[i])
                newArrayList.add(category)
            }
        }

        var adapter = CategoryAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object:CategoryAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                //add code here to navigate to another activity or fragment with the category
                // if you use fragment use  --> safe args
                // with activity use --> putExtra with the intent

                //here I added the dummy toast to show the selected item position

                var clickedItem = categoryText[position]

                Toast.makeText(requireActivity(), "clicked $position : $clickedItem", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
package com.example.farmory.homeMenuTabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.farmory.Itemlist.AdapterItem
import com.example.farmory.Itemlist.Modeitem
import com.example.farmory.R
import com.example.farmory.databinding.FragmentMenuHomeBinding
import com.example.farmory.databinding.FragmentMenuSearchBinding
import com.example.farmory.homeScreen.Category
import com.example.farmory.homeScreen.CategoryAdapter


class MenuHomeFragment : Fragment() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Category>
    lateinit var imageID : Array<Int>
    lateinit var categoryText : Array<String>



    private val titles = arrayOf(
        "Banana",
        "Apple",
        "Cabbage",
        "Brinjal",
        "Carrot",
        "Mango",
        "Bread",
        "Bun",
        "Cup Cake",
    )
    private val descriptions = arrayOf(
        "80",
        "90",
        "100",
        "80",
        "90",
        "100",
        "60",
        "20",
        "50",

    )

    private val images = arrayOf(
        R.drawable.banana,
        R.drawable.item1,
        R.drawable.cabbage,
        R.drawable.brinjal,
        R.drawable.carrot,
        R.drawable.mango,
        R.drawable.bread,
        R.drawable.bun,
        R.drawable.cup_cake,
    )

    private var _binding: FragmentMenuHomeBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMenuHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_menu_home, container, false)

        view.findViewById<TextView>(R.id.seeMoreCategoriesButton).setOnClickListener{
            findNavController().navigate(R.id.action_menuHomeFragment_to_categoriesFragment)
        }
        view.findViewById<TextView>(R.id.seeMoreProducts).setOnClickListener{
            findNavController().navigate(R.id.action_menuHomeFragment_to_menuSearchFragment)
        }

        view.findViewById<com.google.android.material.imageview.ShapeableImageView>(R.id.banner1).setOnClickListener{
            findNavController().navigate(R.id.action_menuHomeFragment_to_promotionFragment)
        }

        view.findViewById<com.google.android.material.imageview.ShapeableImageView>(R.id.banner2).setOnClickListener{
            findNavController().navigate(R.id.action_menuHomeFragment_to_safetyBannerFragment)
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

        loadRecycleViewItems()
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

                val bundle = bundleOf("cat" to clickedItem)
                findNavController().navigate(R.id.action_menuHomeFragment_to_menuSearchFragment,bundle)

//                Toast.makeText(requireActivity(), "clicked $position : $clickedItem", Toast.LENGTH_SHORT).show()

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun loadRecycleViewItems(){

        val gridLayoutManager = GridLayoutManager(requireActivity(),2,)


        binding.productRecyclerView.layoutManager = gridLayoutManager
        binding.productRecyclerView.setHasFixedSize(true)

        val itemList:ArrayList<Modeitem> = ArrayList()

        for (i in titles.indices){
            val model = Modeitem(titles[i],descriptions[i],images[i])

            itemList.add(model)
        }

        val adapterItem = AdapterItem(requireActivity(), itemList)
        binding.productRecyclerView.adapter = adapterItem

    }
}
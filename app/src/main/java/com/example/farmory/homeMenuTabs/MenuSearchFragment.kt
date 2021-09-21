package com.example.farmory.homeMenuTabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.farmory.Itemlist.AdapterItem
import com.example.farmory.Itemlist.Modeitem
import com.example.farmory.R
import com.example.farmory.databinding.ActivityProductListBinding
import com.example.farmory.databinding.FragmentMenuSearchBinding

class MenuSearchFragment : Fragment() {

//    private lateinit var binding: FragmentMenuSearchBinding

    private val titles = arrayOf(
        "Banana",
        "Apple",
        "Cabbage",
        "Banana",
        "Apple",
        "Cabbage",
    )
    private val descriptions = arrayOf(
        "Rs 80 / g",
        "Rs 90 / g",
        "Rs 100 / g",
        "Rs 80 / g",
        "Rs 90 / g",
        "Rs 100 / g",
    )
    private val images = arrayOf(
        R.drawable.item1,
        R.drawable.item1,
        R.drawable.item1,
        R.drawable.item1,
        R.drawable.item1,
        R.drawable.item1,
    )

    private var _binding: FragmentMenuSearchBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        // Inflate the layout for this fragment
        _binding = FragmentMenuSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        view.findViewById<ImageButton>(R.id.back_button).setOnClickListener{
            findNavController().navigate(R.id.action_menuSearchFragment_to_menuHomeFragment)
        }

        loadRecycleViewItems()
//        binding = FragmentMenuSearchBinding.inflate(layoutInflater)

//        return inflater.inflate(R.layout.fragment_menu_search, container, false)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadRecycleViewItems(){
//        val linerLayoutManager = LinearLayoutManager(requireActivity())
        val gridLayoutManager = GridLayoutManager(requireActivity(),2)
//        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,1)

        binding.productList1.layoutManager = gridLayoutManager

        val itemList:ArrayList<Modeitem> = ArrayList()

        for (i in titles.indices){
            val model = Modeitem(titles[i],descriptions[i],images[i])

            itemList.add(model)
        }

        val adapterItem = AdapterItem(requireActivity(), itemList)
        binding.productList1.adapter = adapterItem

    }
}
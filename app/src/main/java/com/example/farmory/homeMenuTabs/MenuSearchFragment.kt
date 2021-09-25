package com.example.farmory.homeMenuTabs

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.farmory.Itemlist.AdapterItem
import com.example.farmory.Itemlist.Modeitem
import com.example.farmory.R
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
        "80",
        "90",
        "100",
        "80",
        "90",
        "100",
    )
    private val images = arrayOf(
        R.drawable.banana,
        R.drawable.item1,
        R.drawable.cabbage,
        R.drawable.banana,
        R.drawable.item1,
        R.drawable.cabbage,
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }
}
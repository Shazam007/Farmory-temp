package com.example.farmory.homeMenuTabs

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageButton
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.farmory.Itemlist.AdapterItem
import com.example.farmory.Itemlist.Modeitem
import com.example.farmory.R
import com.example.farmory.databinding.FragmentMenuSearchBinding

class MenuSearchFragment : Fragment() {


    private val titles = arrayOf(
        "Banana",
        "Apple",
        "Cabbage",
        "Brinjal",
        "Carrot",
        "Mango",
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
        R.drawable.brinjal,
        R.drawable.carrot,
        R.drawable.mango,
    )

    private val itemList:ArrayList<Modeitem> = ArrayList()
    private val matcheditemList:ArrayList<Modeitem> = ArrayList()

    private var _binding: FragmentMenuSearchBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {




        // Inflate the layout for this fragment
        _binding = FragmentMenuSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        view.findViewById<ImageButton>(R.id.back_button).setOnClickListener{
            findNavController().navigate(R.id.action_menuSearchFragment_to_menuHomeFragment)
        }

        loadRecycleViewItems()
        performSearch()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadRecycleViewItems(){

        val gridLayoutManager = GridLayoutManager(requireActivity(),2)


        binding.productList1.layoutManager = gridLayoutManager


        for (i in titles.indices){
            val model = Modeitem(titles[i],descriptions[i],images[i])
            itemList.add(model)
        }

        val adapterItem = AdapterItem(requireActivity(), itemList)
        binding.productList1.adapter = adapterItem
    }

    private fun performSearch() {
        binding.searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                search(newText)
                return true
            }
        })
    }

    private fun search(text: String?) {

        matcheditemList.clear()

        text?.let {
            titles.forEach { person ->
                if (person.contains(text, true)

                ) {
                    val position = findIndex(titles, person)
                    val model1 = Modeitem(titles[position],descriptions[position],images[position])
                    matcheditemList.add(model1)
                }
            }
            updateRecyclerView()
            if (matcheditemList.isEmpty()) {
                Toast.makeText(activity,"No match found!",Toast.LENGTH_SHORT).show()
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {

        val adapterItem1 = AdapterItem(requireActivity(), matcheditemList)
        binding.productList1.adapter = adapterItem1

    }

    private fun findIndex(arr: Array<String>, item: String): Int {
        return arr.indexOf(item)
    }
}
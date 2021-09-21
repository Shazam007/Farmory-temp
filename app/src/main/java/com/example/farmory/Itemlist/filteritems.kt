package com.example.farmory.Itemlist

import android.widget.Filter

class filteritems(filterList: ArrayList<Modeitem>, private val adapterItem: AdapterItem): Filter() {


    private  val filterList: ArrayList<Modeitem> = filterList

    override fun performFiltering(constraint: CharSequence?): FilterResults {
       var constraint1:CharSequence? = constraint
        val results =  FilterResults()

        if(constraint1 != null && constraint1.isNotEmpty()){
            constraint1 = constraint1.toString().toUpperCase()

            val filterModels = ArrayList<Modeitem>()
            for(i in filterList.indices){
                if(filterList[i].title.toUpperCase().contains(constraint1)){
                    filterModels.add(filterList[i])
                }
            }
            results.count = filterModels.size
            results.values = filterModels
        }
        else{
            results.count = filterList.size
            results.values = filterList
        }

        return results

    }

    override fun publishResults(constraint: CharSequence, results: FilterResults) {
        adapterItem.itemList = results.values as ArrayList<Modeitem>

        adapterItem.notifyDataSetChanged()
    }
}
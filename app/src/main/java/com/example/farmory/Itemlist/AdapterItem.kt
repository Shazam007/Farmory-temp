package com.example.farmory.Itemlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.farmory.databinding.ListItemBinding

class AdapterItem(
    private var context: Context,
    private var itemList: ArrayList<Modeitem>
): RecyclerView.Adapter<AdapterItem.HolderItem>() {

    //ViewBinding
    private lateinit var binding: ListItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        //infalte layour using view binder
        binding = ListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return HolderItem(binding.root)
    }

    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        //get data
        val  model = itemList[position]

        var title = model.title
        var description = model.description
        var image = model.image

        //set data
        holder.ItemTitle.text = title
        holder.ItemDescription.text = description
        holder.ItemImage.setImageResource(image)

        //handle item click
        holder.itemView.setOnClickListener{
            Toast.makeText(context, "$title", Toast.LENGTH_SHORT).show()
        }



    }

    override fun getItemCount(): Int {
        //return size of list
        return itemList.size
    }

    //view holder class
    inner class HolderItem(itemView: View): RecyclerView.ViewHolder(itemView){

         var ItemTitle: TextView
         var ItemDescription: TextView
         var ItemImage: ImageView

        init {
            binding = ListItemBinding.bind(itemView)

            //init UI view
            ItemTitle = binding.itemTitle
            ItemDescription = binding.itemDescription
            ItemImage = binding.ItemImage

        }

    }


}
package com.example.farmory.homeScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.farmory.R
import com.google.android.material.imageview.ShapeableImageView

class CategoryAdapter(private val categoryList:ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val categoryImage:ShapeableImageView = itemView.findViewById(R.id.category_image)
        val categoryText:TextView = itemView.findViewById(R.id.category_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = categoryList[position]
        holder.categoryImage.setImageResource(currentItem.categoryImage)
        holder.categoryText.text = currentItem.categoryText

    }

    override fun getItemCount(): Int {
       return categoryList.size;
    }
}
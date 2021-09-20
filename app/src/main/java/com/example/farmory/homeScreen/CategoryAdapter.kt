package com.example.farmory.homeScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.farmory.R
import com.google.android.material.imageview.ShapeableImageView

class CategoryAdapter(private val categoryList:ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener : onItemClickListener){
        mListener = listener
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView) {

        val categoryImage:ShapeableImageView = itemView.findViewById(R.id.category_image)
        val categoryText:TextView = itemView.findViewById(R.id.category_text)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return MyViewHolder(itemView,mListener)

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
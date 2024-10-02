package com.example.baytna.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.baytna.Model.CategoryItems
import com.example.baytna.R

class CategoryAdapter(private val categoryList: List<CategoryItems>):
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTitle: TextView = itemView.findViewById(R.id.TextCategory)
        val categoryImage: ImageView = itemView.findViewById(R.id.CategoryPic)
        val cardView: CardView = itemView.findViewById(R.id.Card_Cat)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = categoryList[position]
        holder.categoryTitle.text = category.title
        holder.categoryImage.setImageResource(category.img)
        holder.cardView.setCardBackgroundColor(category.backgroudColor)
    }

}

package com.example.baytna.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.baytna.Model.WorkerItemsHome
import com.example.baytna.R

class WorkerAdapter(private val WorkerList: List<WorkerItemsHome>):
    RecyclerView.Adapter<WorkerAdapter.MyViewHolder>() {
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val categoryImg: ImageView = itemView.findViewById(R.id.CategoryPicWorker)
            val workerName: TextView = itemView.findViewById(R.id.workerName)
            val workerImg: ImageView = itemView.findViewById(R.id.workerImgId)
            val workerRate: RatingBar = itemView.findViewById(R.id.ratingBar)
            val cardView: CardView = itemView.findViewById(R.id.Card_Worker)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView=
                LayoutInflater.from(parent.context).inflate(R.layout.workerhome_item,parent,false)
            return MyViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return WorkerList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val worker = WorkerList[position]
            holder.workerName.text = worker.name
            holder.workerImg.setImageResource(worker.img)
            holder.workerRate.rating = worker.rating.toFloat()

            val category = worker.Cateory
            holder.categoryImg.setImageResource(category.img)
            holder.cardView.setCardBackgroundColor(category.backgroudColor)
        }

    }

package com.example.baytna.Activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baytna.Adapter.CategoryAdapter
import com.example.baytna.Adapter.WorkerAdapter
import com.example.baytna.Model.CategoryItems
import com.example.baytna.Model.WorkerItemsHome
import com.example.baytna.R

class Home : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var recyclerViewWorker: RecyclerView
    private lateinit var WorkerAdapter: WorkerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val categoryList = listOf(
            CategoryItems("Cleaning", R.drawable.cleaning_cat, Color.parseColor("#008B8B")),
            CategoryItems("Electrical", R.drawable.electrical_cat,Color.parseColor("#5C6769")),//
            CategoryItems("Baby Care", R.drawable.baby_cat, Color.parseColor("#458b9b")),
            CategoryItems("Beauty Care", R.drawable.beauty_cat, Color.parseColor("#d3a783")) ,//
            CategoryItems("Garden", R.drawable.garden_cat, Color.parseColor("#219688")),
            CategoryItems("Paint", R.drawable.paint_cat, Color.parseColor("#20B2AA")),//
            CategoryItems("Plumbing", R.drawable.plumbing_cat, Color.parseColor("#6082b2"))

        )
        val WorkerList= listOf(
            WorkerItemsHome("Worker1",R.drawable.worker,3,  CategoryItems("Garden", R.drawable.garden_cat, Color.parseColor("#219688")),),
            WorkerItemsHome("Worker1",R.drawable.worker,3, CategoryItems("Cleaning", R.drawable.cleaning_cat, Color.parseColor("#008B8B")),),
            WorkerItemsHome("Worker1",R.drawable.worker,3, CategoryItems("Electrical", R.drawable.electrical_cat,Color.parseColor("#86768a")),),
            WorkerItemsHome("Worker1",R.drawable.worker,3, CategoryItems("Cleaning", R.drawable.cleaning_cat, Color.parseColor("#008B8B")),),
            WorkerItemsHome("Worker1",R.drawable.worker,3,  CategoryItems("Garden", R.drawable.garden_cat, Color.parseColor("#219688")),),

            )

        recyclerView = findViewById(R.id.Category_RecycleView)
        categoryAdapter = CategoryAdapter(categoryList)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = categoryAdapter

        recyclerViewWorker=findViewById(R.id.workers_RecycleView)
        WorkerAdapter=WorkerAdapter(WorkerList)
        recyclerViewWorker.layoutManager=LinearLayoutManager(this)
        recyclerViewWorker.adapter=WorkerAdapter



    }
}
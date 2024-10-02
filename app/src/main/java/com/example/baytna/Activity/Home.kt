package com.example.baytna.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baytna.Adapter.CategoryAdapter
import com.example.baytna.Adapter.WorkerAdapter
import com.example.baytna.Const.WorkerList
import com.example.baytna.Const.categoryList
import com.example.baytna.Model.CategoryItems
import com.example.baytna.Model.WorkerItemsHome
import com.example.baytna.R

class Home : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var recyclerViewWorker: RecyclerView
    private lateinit var WorkerAdapter: WorkerAdapter
    private lateinit var viewAll:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        //Category
        recyclerView = findViewById(R.id.Category_RecycleView)
        categoryAdapter = CategoryAdapter(categoryList)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = categoryAdapter

        //Workers
        recyclerViewWorker=findViewById(R.id.workers_RecycleView)
        WorkerAdapter=WorkerAdapter(WorkerList)
        recyclerViewWorker.layoutManager=LinearLayoutManager(this)
        recyclerViewWorker.adapter=WorkerAdapter


        viewAll=findViewById(R.id.viewAllId)
        viewAll.setOnClickListener(View.OnClickListener {
           var intent=Intent(this,gridViewCategory::class.java)
            startActivity(intent)
        })


    }
}
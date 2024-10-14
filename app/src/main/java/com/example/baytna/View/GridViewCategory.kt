package com.example.baytna.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baytna.Adapter.CategoryAdapter
import com.example.baytna.Const.categoryList
import com.example.baytna.R

class gridViewCategory : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var backArrow:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_category)

        recyclerView = findViewById(R.id.Category_RecycleView_grid)
        categoryAdapter = CategoryAdapter(categoryList)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = categoryAdapter

        backArrow=findViewById(R.id.backArrow)
        backArrow.setOnClickListener(View.OnClickListener {
            var intent= Intent(this,Home::class.java)
            startActivity(intent)
        })
    }
}
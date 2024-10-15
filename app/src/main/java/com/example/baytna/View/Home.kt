package com.example.baytna.View

import HomePresenter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baytna.Adapter.CategoryAdapter
import com.example.baytna.Adapter.WorkerAdapter
import com.example.baytna.Model.CategoryItems
import com.example.baytna.Model.WorkerItemsHome
import com.example.baytna.Model.CategoryModel
import com.example.baytna.Model.WorkerModel
import com.example.baytna.R

class Home : AppCompatActivity(), HomeView {

    private lateinit var recyclerViewCategory: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var recyclerViewWorker: RecyclerView
    private lateinit var workerAdapter: WorkerAdapter
    private lateinit var viewAll: TextView
    private lateinit var presenter: HomePresenter

    private var categoryList: List<CategoryItems> = emptyList()
    private var workerList: List<WorkerItemsHome> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize models and presenter
        val workerModel = WorkerModel()
        val categoryModel = CategoryModel()
        presenter = HomePresenter(this, workerModel, categoryModel)

        // Initialize Category RecyclerView
        recyclerViewCategory = findViewById(R.id.Category_RecycleView)
        recyclerViewCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Initialize Worker RecyclerView
        recyclerViewWorker = findViewById(R.id.workers_RecycleView)
        recyclerViewWorker.layoutManager = LinearLayoutManager(this)

        // Load Categories and Workers using the presenter
        presenter.loadCategories()
        presenter.loadRecommendedWorkers()

        // Setup viewAll button click to navigate to gridViewCategory
        viewAll = findViewById(R.id.viewAllId)
        viewAll.setOnClickListener {
            val intent = Intent(this, gridViewCategory::class.java)
            startActivity(intent)
        }
    }

    // HomeView Implementation

    override fun showCategories(categories: List<CategoryItems>) {
        // Store categories and update the adapter
        categoryList = categories
        categoryAdapter = CategoryAdapter(categoryList)
        recyclerViewCategory.adapter = categoryAdapter
    }

    override fun showEmptyCategories() {
        // Handle empty categories
        recyclerViewCategory.visibility = View.GONE
    }

    override fun showRecommendedWorkers(workers: List<WorkerItemsHome>) {
        // Store workers and update the worker adapter
        workerList = workers
        workerAdapter = WorkerAdapter(workerList, categoryList) // Pass both workerList and categoryList
        recyclerViewWorker.adapter = workerAdapter
    }

    override fun showEmptyWorkers() {
        // Handle empty workers
        recyclerViewWorker.visibility = View.GONE
    }
}

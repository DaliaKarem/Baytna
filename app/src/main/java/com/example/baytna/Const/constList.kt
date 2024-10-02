package com.example.baytna.Const

import android.graphics.Color
import com.example.baytna.Model.CategoryItems
import com.example.baytna.Model.WorkerItemsHome
import com.example.baytna.R

val categoryList = listOf(
    CategoryItems("Cleaning", R.drawable.cleaning_cat, Color.parseColor("#008B8B")),
    CategoryItems("Electrical", R.drawable.electrical_cat, Color.parseColor("#5C6769")),//
    CategoryItems("Baby Care", R.drawable.baby_cat, Color.parseColor("#458b9b")),
    CategoryItems("Beauty Care", R.drawable.beauty_cat, Color.parseColor("#d3a783")) ,//
    CategoryItems("Garden", R.drawable.garden_cat, Color.parseColor("#219688")),
    CategoryItems("Paint", R.drawable.paint_cat, Color.parseColor("#20B2AA")),//
    CategoryItems("Plumbing", R.drawable.plumbing_cat, Color.parseColor("#6082b2"))

)
val WorkerList= listOf(
    WorkerItemsHome("Worker1",
        R.drawable.worker,3, categoryList.get(0) ),
    WorkerItemsHome("Worker1",
        R.drawable.worker,3, categoryList.get(1) ),
    WorkerItemsHome("Worker1",
        R.drawable.worker,3, categoryList.get(2) ),
    WorkerItemsHome("Worker1",
        R.drawable.worker,3, categoryList.get(1) ),
    WorkerItemsHome("Worker1",
        R.drawable.worker,3, categoryList.get(2) ),
    WorkerItemsHome("Worker1",
        R.drawable.worker,3, categoryList.get(0) ),
    )
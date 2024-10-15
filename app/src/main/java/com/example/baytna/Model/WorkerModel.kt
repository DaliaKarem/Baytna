package com.example.baytna.Model

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class WorkerModel {

    private val database = FirebaseDatabase.getInstance().getReference("Workers")

    // Fetch single worker by ID
    fun getWorker(id: String, callback: WorkerCallback) {
        val workerId = database.child(id)

        workerId.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val name = snapshot.child("Name").getValue(String::class.java)
                val price = snapshot.child("Price").getValue(String::class.java)
                val rate = snapshot.child("Rate").getValue(Double::class.java)
                val imagePath = snapshot.child("ImagePath").getValue(String::class.java)
                val categoryId = snapshot.child("CategoryId").getValue(String::class.java)
                val mobile = snapshot.child("Mobile").getValue(String::class.java)

                callback.onProfileLoaded(name, price, rate, imagePath, categoryId, mobile)
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onFailure(error.message)
            }
        })
    }

    // Fetch all workers
    fun getAllWorkers(callback: WorkerCallback) {
        val allWorkers = mutableListOf<WorkerItemsHome>()
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (childSnapshot in snapshot.children) {
                        val worker = childSnapshot.getValue(WorkerItemsHome::class.java)
                        worker?.let { allWorkers.add(it) }
                    }
                    callback.onAllWorkersLoaded(allWorkers)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onFailure(error.message)
            }
        })
    }

    // Fetch workers by category
    fun getWorkersByCategory(categoryId: String, callback: WorkerCallback) {
        database.orderByChild("CategoryId").equalTo(categoryId)
            .get().addOnSuccessListener { snapshot ->
                val workers = snapshot.children.mapNotNull { it.getValue(WorkerItemsHome::class.java) }
                callback.onAllWorkersLoaded(workers)
            }
    }
}

interface WorkerCallback {
    fun onProfileLoaded(
        name: String?,
        price: String?,
        rate: Double?,
        imagePath: String?,
        categoryId: String?,
        mobile: String?
    )

    fun onAllWorkersLoaded(workers: List<WorkerItemsHome>)
    fun onFailure(message: String)
}

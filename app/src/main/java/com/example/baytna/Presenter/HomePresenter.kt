import android.util.Log
import com.example.baytna.Model.CategoryModel
import com.example.baytna.Model.WorkerModel
import com.example.baytna.View.HomeView
import com.example.baytna.Model.CategoryItems
import com.example.baytna.Model.WorkerCallback

import com.example.baytna.Model.CategoryCallback
import com.example.baytna.Model.WorkerItemsHome


interface presenterInter {
    fun loadCategories()
    fun loadRecommendedWorkers()
}
class HomePresenter(
    private val view: HomeView,
    private val workerModel: WorkerModel,
    private val categoryModel: CategoryModel
) : presenterInter {

    override fun loadCategories() {
        categoryModel.getAllCategories(object : CategoryCallback {
            override fun onAllCategoriesLoaded(categories: List<CategoryItems>) {
                if (categories.isNotEmpty()) {
                    view.showCategories(categories)
                } else {
                    view.showEmptyCategories()
                }
            }

            override fun onFailure(message: String) {
                // Handle failure if needed
            }
        })
    }

    override fun loadRecommendedWorkers() {
        workerModel.getAllWorkers(object : WorkerCallback {
            override fun onProfileLoaded(name: String?, price: String?, rate: Double?, imagePath: String?, categoryId: String?, mobile: String?) {
                // Handle worker profile loaded if needed
            }

            override fun onAllWorkersLoaded(workers: List<WorkerItemsHome>) {
                if (workers.isNotEmpty()) {
                    Log.d("chackworker" , "check"+workers)
// ********* Rate
                    view.showRecommendedWorkers(workers)
                } else {
                    view.showEmptyWorkers()
                }
            }

            override fun onFailure(message: String) {
                // Handle failure if needed
            }
        })
    }
}

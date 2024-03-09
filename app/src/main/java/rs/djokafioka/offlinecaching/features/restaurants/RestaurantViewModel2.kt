package rs.djokafioka.offlinecaching.features.restaurants

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import rs.djokafioka.offlinecaching.data.Restaurant
import rs.djokafioka.offlinecaching.data.RestaurantDatabase
import rs.djokafioka.offlinecaching.data.RestaurantRepository2

/**
 * Created by Djordje on 9.9.2022..
 */
class RestaurantViewModel2(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Restaurant>>
    private val repository: RestaurantRepository2

    init {
        val restaurantDao = RestaurantDatabase.getDatabase(application).restaurantDao()
        repository = RestaurantRepository2(restaurantDao)
        readAllData = repository.readAllData
    }

    fun addRestaurants(restaurants: List<Restaurant>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRestaurants(restaurants)
        }
    }
}
package rs.djokafioka.offlinecaching.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData

/**
 * Created by Djordje on 9.9.2022..
 */
//Repository bez Network Bound Resource
class RestaurantRepository2(private val restaurantDao: RestaurantDao)  {
    val readAllData: LiveData<List<Restaurant>> = restaurantDao.getAllRestaurants().asLiveData()

    suspend fun addRestaurants(restaurants: List<Restaurant>) {
        restaurantDao.insertRestaurants(restaurants)
    }
}
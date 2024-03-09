package rs.djokafioka.offlinecaching.data

import androidx.room.withTransaction
import kotlinx.coroutines.delay
import rs.djokafioka.offlinecaching.api.RestaurantApi
import rs.djokafioka.offlinecaching.util.networkBoundResource
import javax.inject.Inject

/**
 * Created by Djordje on 9.9.2022..
 */
class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
){
    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)//Just for test
            api.getRestaurants()
        },
        saveFetchResult =  { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}
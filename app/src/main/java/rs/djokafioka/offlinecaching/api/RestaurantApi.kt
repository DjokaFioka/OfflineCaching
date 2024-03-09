package rs.djokafioka.offlinecaching.api

import retrofit2.http.GET
import rs.djokafioka.offlinecaching.data.Restaurant

/**
 * Created by Djordje on 8.9.2022..
 */
interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>
}
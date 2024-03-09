package rs.djokafioka.offlinecaching.features.restaurants

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import rs.djokafioka.offlinecaching.api.RestaurantApi
import rs.djokafioka.offlinecaching.data.Restaurant
import rs.djokafioka.offlinecaching.data.RestaurantRepository
import javax.inject.Inject

/**
 * Created by Djordje on 8.9.2022..
 */
@HiltViewModel
class RestaurantViewModel @Inject constructor(
//    api: RestaurantApi //dok nismo napravili NetworkBoundResource Repository
    repository: RestaurantRepository
) : ViewModel() {
    val restaurants = repository.getRestaurants().asLiveData()

    //dok nismo napravili NetworkBoundResource Repository
//    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurants : LiveData<List<Restaurant>> = restaurantsLiveData;
//
//    init {
//        viewModelScope.launch {
//            val restaurants = api.getRestaurants()
//            delay(2000L) //for testing purposes
//            restaurantsLiveData.value = restaurants
//        }
//    }
}
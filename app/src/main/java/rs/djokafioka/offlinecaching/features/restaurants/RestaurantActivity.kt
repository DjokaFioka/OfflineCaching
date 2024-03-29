package rs.djokafioka.offlinecaching.features.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import rs.djokafioka.offlinecaching.R
import rs.djokafioka.offlinecaching.databinding.ActivityRestaurantBinding
import rs.djokafioka.offlinecaching.util.Resource

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private val viewModel: RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()
        binding.apply {
            recyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }

            viewModel.restaurants.observe(this@RestaurantActivity) { result ->
                restaurantAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage
            }

            //dok nismo napravili NetworkBoundResource Repository
//            viewModel.restaurants.observe(this@RestaurantActivity) { restaurants ->
//                restaurantAdapter.submitList(restaurants)
//            }
        }
    }
}
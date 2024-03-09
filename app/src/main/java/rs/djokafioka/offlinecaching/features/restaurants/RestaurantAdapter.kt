package rs.djokafioka.offlinecaching.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import rs.djokafioka.offlinecaching.data.Restaurant
import rs.djokafioka.offlinecaching.databinding.RestaurantItemBinding

/**
 * Created by Djordje on 8.9.2022..
 */
class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantComparator()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurant) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(imageViewLogo)

                textViewName.text = restaurant.name
                textViewType.text = restaurant.type
                textViewAddress.text = restaurant.address
            }
        }
    }

    class RestaurantComparator : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.name == newItem.name //uzecemo da je naziv jedinstven
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem //posto je Restaurant data class ovo poredjenje se radi za sve sto se nalazi u primarnom konstruktoru
        }
    }

}
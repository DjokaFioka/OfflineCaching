package rs.djokafioka.offlinecaching.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Created by Djordje on 9.9.2022..
 */
@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurants")
    //we don't need suspend because the flow is cold
    // declaring a flow and returning it doesnt't yet execute it
    // only when we collect from the flow it starts emitting values
    // and execute the work inside it. So returning a flow
    // is not a long running operation and we don't need a suspend modifier
    fun getAllRestaurants(): Flow<List<Restaurant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurants: List<Restaurant>)

    @Query("DELETE FROM restaurants")
    suspend fun deleteAllRestaurants()
}
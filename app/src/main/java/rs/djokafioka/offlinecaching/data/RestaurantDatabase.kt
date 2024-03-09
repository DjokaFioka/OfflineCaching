package rs.djokafioka.offlinecaching.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Djordje on 9.9.2022..
 */
@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase(){

    abstract fun restaurantDao(): RestaurantDao
}
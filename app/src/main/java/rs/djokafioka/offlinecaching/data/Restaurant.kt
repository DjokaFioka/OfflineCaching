package rs.djokafioka.offlinecaching.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Djordje on 8.9.2022..
 */
@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey val name: String,
    val type: String,
    val logo: String,
    val address: String
) {
}
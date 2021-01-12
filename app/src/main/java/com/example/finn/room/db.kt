package com.example.finn.room

import androidx.room.*
import com.example.finn.data.*
import com.squareup.moshi.Moshi
import io.reactivex.rxjava3.core.Flowable

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg item: Item)

    @Delete
    fun delete(item: Item)

    @Query("SELECT * FROM items")
    fun getItemsFlowable(): Flowable<List<Item>>

    @Query("SELECT * FROM items WHERE id = :itemId")
    fun checkItemExists(itemId: String): List<Item>
}

@TypeConverters(Converters::class)
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
}

class Converters {

    private val moshi: Moshi = Moshi.Builder().build()

    @TypeConverter
    fun imageFromJson(value: String): Image? {
        return ImageJsonAdapter(moshi).fromJson(value)
    }

    @TypeConverter
    fun jsonToImage(image: Image): String {
        return ImageJsonAdapter(moshi).toJson(image)
    }

    @TypeConverter
    fun priceFromJson(value: String): Price? {
        return PriceJsonAdapter(moshi).fromJson(value)
    }

    @TypeConverter
    fun jsonToPrice(price: Price): String {
        return PriceJsonAdapter(moshi).toJson(price)
    }

    @TypeConverter
    fun trackingFromJson(value: String): Tracking? {
        return TrackingJsonAdapter(moshi).fromJson(value)
    }

    @TypeConverter
    fun jsonToTracking(tracking: Tracking): String {
        return TrackingJsonAdapter(moshi).toJson(tracking)
    }

}
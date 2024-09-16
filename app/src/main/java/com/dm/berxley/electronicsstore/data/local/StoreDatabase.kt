package com.dm.berxley.electronicsstore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dm.berxley.electronicsstore.domain.models.Category
import com.dm.berxley.electronicsstore.domain.models.Product
import com.dm.berxley.electronicsstore.domain.models.User

@Database(entities = [Category::class, Product::class, User::class], version = 2)
@TypeConverters(ImagesListConverter::class)
abstract class StoreDatabase : RoomDatabase() {
    abstract val storeDao: StoreDao

    companion object {
        const val ROOM_DB_NAME = "electronics_store_db"
    }
}

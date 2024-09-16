package com.dm.berxley.electronicsstore.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

@ProvidedTypeConverter
class ImagesListConverter {
    @TypeConverter
    fun listToString(list: List<String>): String {
        return list.joinToString(separator = ",")
    }

    @TypeConverter
    fun stringToList(string: String): List<String>{
        return  string.split(",")
    }
}
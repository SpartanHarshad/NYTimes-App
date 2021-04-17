package com.example.nytimes.local

import androidx.room.TypeConverter
import com.example.nytimes.model.Source

class Converter {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}
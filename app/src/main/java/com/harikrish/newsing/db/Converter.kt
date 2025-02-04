package com.harikrish.newsing.db

import androidx.room.TypeConverter
import com.harikrish.newsing.model.Source

class Converter {

    @TypeConverter
    fun fromSource(source: Source) : String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String) : Source {
        return Source(name, name)
    }
}
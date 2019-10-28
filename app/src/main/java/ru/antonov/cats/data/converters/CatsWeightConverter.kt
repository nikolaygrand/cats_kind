package ru.antonov.cats.data.converters

import com.google.gson.Gson
import io.objectbox.converter.PropertyConverter
import ru.antonov.cats.data.CatsWeight

class CatsWeightConverter: PropertyConverter<CatsWeight, String> {
    override fun convertToDatabaseValue(entityProperty: CatsWeight?): String {
        val gson = Gson()
        return gson.toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): CatsWeight {
        val gson = Gson()
        return gson.fromJson(databaseValue, CatsWeight::class.java)
    }
}
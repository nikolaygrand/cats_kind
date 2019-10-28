package ru.antonov.cats.data

import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import org.greenrobot.essentials.io.LimitedInputStream
import ru.antonov.cats.data.converters.CatsWeightConverter

@Entity
data class CatsBreads(
    @Id
    var iid: Long = 0,
    var adaptability: Int,
    var affection_level: Int,
    var alt_names: String,
    var cfa_url: String,
    var child_friendly: Int,
    var country_code: String,
    var country_codes: String,
    var description: String,
    var dog_friendly: Int,
    var energy_level: Int,
    var experimental: Int,
    var grooming: Int,
    var hairless: Int,
    var health_issues: Int,
    var hypoallergenic: Int,
    var id: String,
    var indoor: Int,
    var intelligence: Int,
    var lap: Int,
    var life_span: String,
    var name: String,
    var natural: Int,
    var origin: String,
    var rare: Int,
    var rex: Int,
    var shedding_level: Int,
    var short_legs: Int,
    var social_needs: Int,
    var stranger_friendly: Int,
    var suppressed_tail: Int,
    var temperament: String,
    var vcahospitals_url: String,
    var vetstreet_url: String,
    var vocalisation: Int,
    @Convert(converter = CatsWeightConverter::class, dbType = String::class)
    var weight: CatsWeight,
    var wikipedia_url: String
)
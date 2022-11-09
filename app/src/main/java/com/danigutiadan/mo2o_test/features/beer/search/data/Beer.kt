package com.danigutiadan.mo2o_test.features.beer.search.data

import com.danigutiadan.mo2o_test.api.BaseApi
import com.danigutiadan.mo2o_test.api.BaseModel
import com.google.gson.annotations.SerializedName

/*
data class BeerResponseList(
    var beers: List<BaseModel>
) : BaseModel() {
    override fun toApi(): BeerResponseListApi {
        val beerListApi = mutableListOf<BaseApi>()
        beers.forEach {
            it.toApi()?.apply { beerListApi.add(this) } }
        return BeerResponseListApi(beerListApi)

    }
}

data class BeerResponseListApi(
    var beers: List<BaseApi>
) : BaseApi() {
    override fun toModel(): BeerResponseList {
        val beerList = mutableListOf<BaseModel>()
        beers.forEach {
            it.toModel()?.apply { beerList.add(this) } }
        return BeerResponseList(beerList)

    }
}
*/

data class BeerResponse(

    var id: Int? = null,
    var name: String? = null,
    var tagline: String? = null,
    var firstBrewed: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var abv: Double? = null,
    var ibu: Double? = null,
    var targetFg: Double? = null,
    var targetOg: Double? = null,
    var ebc: Double? = null,
    var srm: Double? = null,
    var ph: Double? = null,
    var attenuationLevel: Double? = null,
    var volume: Volume? = null,
    var boilVolume: BoilVolume? = null,
    var method: Method? = null,
    var ingredients: Ingredients? = null,
    var foodPairing: List<String>? = null,
    var brewersTips: String? = null,
    var contributedBy: String? = null

) : BaseModel() {
    override fun toApi(): BeerResponseApi? {
        return BeerResponseApi(
            id,
            name,
            tagline,
            firstBrewed,
            description,
            imageUrl,
            abv,
            ibu,
            targetFg,
            targetOg,
            ebc,
            srm,
            ph,
            attenuationLevel,
            volume?.toApi(),
            boilVolume?.toApi(),
            method?.toApi(),
            ingredients,
            foodPairing,
            brewersTips,
            contributedBy
        )
    }
}

data class BeerResponseApi(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("tagline") var tagline: String? = null,
    @SerializedName("first_brewed") var firstBrewed: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("abv") var abv: Double? = null,
    @SerializedName("ibu") var ibu: Double? = null,
    @SerializedName("target_fg") var targetFg: Double? = null,
    @SerializedName("target_og") var targetOg: Double? = null,
    @SerializedName("ebc") var ebc: Double? = null,
    @SerializedName("srm") var srm: Double? = null,
    @SerializedName("ph") var ph: Double? = null,
    @SerializedName("attenuation_level") var attenuationLevel: Double? = null,
    @SerializedName("volume") var volume: VolumeApi? = null,
    @SerializedName("boil_volume") var boilVolume: BoilVolumeApi? = null,
    @SerializedName("method") var method: MethodApi? = null,
    @SerializedName("ingredients") var ingredients: Ingredients? = null,
    @SerializedName("food_pairing") var foodPairing: List<String>? = null,
    @SerializedName("brewers_tips") var brewersTips: String? = null,
    @SerializedName("contributed_by") var contributedBy: String? = null

) : BaseApi() {
    override fun toModel(): BeerResponse? {
        return BeerResponse(
            id,
            name,
            tagline,
            firstBrewed,
            description,
            imageUrl,
            abv,
            ibu,
            targetFg,
            targetOg,
            ebc,
            srm,
            ph,
            attenuationLevel,
            volume?.toModel(),
            boilVolume?.toModel(),
            method?.toModel(),
            ingredients,
            foodPairing,
            brewersTips,
            contributedBy
        )
    }
}


data class Volume(
    var value: Int? = null,
    var unit: String? = null

) : BaseModel() {
    override fun toApi() = VolumeApi(value, unit)
}


data class VolumeApi(

    @SerializedName("value") var value: Int? = null,
    @SerializedName("unit") var unit: String? = null

) : BaseApi() {
    override fun toModel() = Volume(value, unit)
}

data class BoilVolume(

    var value: Int? = null,
    var unit: String? = null

) : BaseModel() {
    override fun toApi() = BoilVolumeApi(value, unit)
}


data class BoilVolumeApi(

    @SerializedName("value") var value: Int? = null,
    @SerializedName("unit") var unit: String? = null

) : BaseApi() {
    override fun toModel() = BoilVolume(value, unit)
}

data class Temp(

    var value: Int? = null,
    var unit: String? = null

) : BaseModel() {
    override fun toApi() = TempApi(value, unit)
}

data class TempApi(

    @SerializedName("value") var value: Int? = null,
    @SerializedName("unit") var unit: String? = null

) : BaseApi() {
    override fun toModel() = Temp(value, unit)
}

data class MashTemp(

    var temp: Temp? = null,
    var duration: Int? = null

) : BaseModel() {
    override fun toApi() = MashTempApi(temp?.toApi(), duration)
}


data class MashTempApi(

    @SerializedName("temp") var temp: TempApi? = null,
    @SerializedName("duration") var duration: Int? = null

) : BaseApi() {
    override fun toModel() = MashTemp(temp?.toModel(), duration)
}

data class Fermentation(

    var temp: Temp? = null

) : BaseModel() {
    override fun toApi() = FermentationApi(temp?.toApi())
}

data class FermentationApi(

    @SerializedName("temp") var temp: TempApi? = null

) : BaseApi() {
    override fun toModel() = Fermentation(temp?.toModel())
}

data class Method(

    var mashTemp: List<MashTemp>? = null,
    var fermentation: Fermentation? = null,
    var twist: String? = null

) : BaseModel() {
    override fun toApi(): MethodApi? {
        val mashTempApi = mutableListOf<MashTempApi>()
        mashTemp?.forEach {
            mashTempApi.add(it.toApi())
        }
        return MethodApi(mashTempApi, fermentation?.toApi(), twist)
    }
}

data class MethodApi(
    @SerializedName("mash_temp") var mashTemp: List<MashTempApi>? = null,
    @SerializedName("fermentation") var fermentation: FermentationApi? = null,
    @SerializedName("twist") var twist: String? = null
) : BaseApi() {
    override fun toModel(): Method? {
        val mashTempModel = mutableListOf<MashTemp>()
        mashTemp?.forEach {
            mashTempModel.add(it.toModel())
        }

        return Method(mashTempModel, fermentation?.toModel(), twist)
    }
}

data class Amount(

    var value: Double? = null,
    var unit: String? = null

) : BaseModel() {
    override fun toApi() = AmountApi(value, unit)
}

data class AmountApi(

    @SerializedName("value") var value: Double? = null,
    @SerializedName("unit") var unit: String? = null

) : BaseApi() {
    override fun toModel() = Amount(value, unit)
}

data class Ingredient(

    var name: String? = null,
    var amount: Amount? = null

) : BaseModel() {
    override fun toApi() = IngredientApi(name, amount?.toApi())
}

data class IngredientApi(

    @SerializedName("name") var name: String? = null,
    @SerializedName("amount") var amount: AmountApi? = null

) : BaseApi() {
    override fun toModel() = Ingredient(name, amount?.toModel())
}

data class Ingredients(

    var malt: List<Ingredient>? = null,
    var hops: List<Ingredient>? = null,
    var yeast: String? = null

) : BaseModel() {
    override fun toApi(): BaseApi? {
        val maltApi = mutableListOf<IngredientApi>()
        malt?.forEach {
            maltApi.add(it.toApi())
        }

        val hopsApi = mutableListOf<IngredientApi>()
        hops?.forEach {
            hopsApi.add(it.toApi())
        }
        return IngredientsApi(maltApi, hopsApi, yeast)
    }
}


data class IngredientsApi(

    @SerializedName("malt") var malt: List<IngredientApi>? = null,
    @SerializedName("hops") var hops: List<IngredientApi>? = null,
    @SerializedName("yeast") var yeast: String? = null

) : BaseApi() {
    override fun toModel(): BaseModel? {
        val maltModel = mutableListOf<Ingredient>()
        malt?.forEach {
            maltModel.add(it.toModel())
        }

        val hopsModel = mutableListOf<Ingredient>()
        hops?.forEach {
            hopsModel.add(it.toModel())
        }
        return Ingredients(maltModel, hopsModel, yeast)
    }
}
package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Code
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import java.util.*

// TODO bude potreba neco pridavat nevystacime si s Product a Crop a name

class Product {
    private val name : String
    private val type : ProductType
    private val uuid : UUID
    private val ingredients : List<Crop>
    private var shopPrice : Double
    private var productionCost : Double
    private var amount : Int
    private val unit : String

    constructor(
        name: String,
        type: ProductType,
        ingredients: List<Crop>,
        shopPrice: Double,
        productionCost: Double,
        amount: Int,
        unit: String
    ) {
        this.name = name
        this.type = type
        this.uuid = UUID.randomUUID()
        this.ingredients = ingredients
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.amount = amount
        this.unit = unit
    }
}
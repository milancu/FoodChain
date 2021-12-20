package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Code
import java.util.*

// TODO bude potreba neco pridavat nevystacime si s Product a Crop a name

class Product {
    private val name : String
    private val uuid : UUID
    private val ingredients : List<Crop>
    private var shopPrice : Double
    private var productionCost : Double
    private var amount : Int
    private val unit : String

    constructor(
        name: String,
        ingredients: List<Crop>,
        shopPrice: Double,
        productionCost: Double,
        amount: Int,
        unit: String
    ) {
        this.name = name
        this.uuid = UUID.randomUUID()
        this.ingredients = ingredients
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.amount = amount
        this.unit = unit
    }
}
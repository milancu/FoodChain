package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Code
import java.util.*

class Crop {
    val name: String
        get() = field
    var amount: Int
        get() = field
        set(value) {
            amount = value
        }
    private val code : Code
    private var shopPrice : Double
    private var productionCost : Double
    private val growthTime : Int

    constructor(name: String, amount: Int, code: Code, shopPrice: Double, productionCost: Double, growthTime: Int) {
        this.name = name
        this.amount = amount
        this.code = code
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.growthTime = growthTime
    }


}
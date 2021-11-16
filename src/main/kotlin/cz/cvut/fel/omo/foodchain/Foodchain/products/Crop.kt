package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Code
import java.util.*

class Crop {
    private val name : String
    private val amount : Int
    private val code : Code
    private var shopPrice : Double
    private var productionCost : Double
    private val growthTime : Date // TODO ???

    constructor(name: String, amount: Int, code: Code, shopPrice: Double, productionCost: Double, growthTime: Date) {
        this.name = name
        this.amount = amount
        this.code = code
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.growthTime = growthTime
    }
}
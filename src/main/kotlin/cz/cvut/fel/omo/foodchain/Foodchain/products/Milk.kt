package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import java.util.*

class Milk {
    private val name: String
    private var amount: Int
    private val uuid : UUID
    private var shopPrice : Double
    private var productionCost : Double

    constructor(name: String, amount: Int, shopPrice: Double, productionCost: Double) {
        this.name = name
        this.uuid = UUID.randomUUID()
        this.amount = amount
        this.shopPrice = shopPrice
        this.productionCost = productionCost
    }
}
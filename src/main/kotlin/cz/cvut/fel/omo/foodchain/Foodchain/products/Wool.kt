package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import java.util.*

class Wool {
    private val name: CropName
    private var amount: Int
    private val uuid : UUID
    private var shopPrice : Double
    private var productionCost : Double

    constructor(name: CropName, amount: Int, shopPrice: Double, productionCost: Double) {
        this.name = name
        this.amount = amount
        this.uuid = UUID.randomUUID()
        this.shopPrice = shopPrice
        this.productionCost = productionCost
    }
}